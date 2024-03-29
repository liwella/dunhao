package com.liwell.cinema.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.liwell.cinema.domain.dto.CategoryAddDTO;
import com.liwell.cinema.domain.dto.CategoryMoveDTO;
import com.liwell.cinema.domain.dto.CategoryUpdateDTO;
import com.liwell.cinema.domain.dto.IdDTO;
import com.liwell.cinema.domain.entity.Category;
import com.liwell.cinema.domain.entity.Movie;
import com.liwell.cinema.domain.entity.RoleCategory;
import com.liwell.cinema.domain.entity.UserRole;
import com.liwell.cinema.domain.enums.ResultEnum;
import com.liwell.cinema.domain.po.Result;
import com.liwell.cinema.domain.vo.CategoryListVO;
import com.liwell.cinema.exception.ResultException;
import com.liwell.cinema.mapper.UserRoleMapper;
import com.liwell.cinema.service.CategoryService;
import com.liwell.cinema.service.MovieService;
import com.liwell.cinema.service.RoleCategoryService;
import com.liwell.cinema.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2023/02/01
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RoleCategoryService roleCategoryService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 分类展示
     * @return
     */
    @PostMapping("/listCategory")
    public Result<List<CategoryListVO>> listCategory() {
        return ResultUtil.success(categoryService.listCategory(null));
    }

    /**
     * 用户分类展示
     * @return
     */
    @PostMapping("/listUserCategory")
    public Result<List<CategoryListVO>> listUserCategory() {
        if (!StpUtil.isLogin()) {
            throw new ResultException(ResultEnum.NOT_LOGGING);
        }
        Integer roleId = userRoleMapper.selectOne(
                new QueryWrapper<UserRole>().eq("user_id", StpUtil.getLoginIdAsInt())).getRoleId();
        return ResultUtil.success(categoryService.listUserCategory(roleId,null));
    }

    /**
     * 新增分类
     * @param dto
     * @return
     */
    @PostMapping("/addCategory")
    public Result addCategory(@RequestBody @Valid CategoryAddDTO dto) {
        return ResultUtil.trueOrFalse(categoryService.addCategory(dto));
    }

    /**
     * 上下移动分类
     * @param dto
     * @return
     */
    @PostMapping("/moveCategory")
    public Result moveCategory(@RequestBody @Valid CategoryMoveDTO dto) {
        return ResultUtil.trueOrFalse(categoryService.moveCategory(dto));
    }

    /**
     * 更新分类
     * @param dto
     * @return
     */
    @PostMapping("/updateCategory")
    public Result updateCategory(@RequestBody @Valid CategoryUpdateDTO dto) {
        categoryService.update(new UpdateWrapper<Category>()
                .set("name", dto.getName()).eq("id", dto.getId()));
        return ResultUtil.success();
    }

    /**
     * 删除分类
     * @param dto
     * @return
     */
    @PostMapping("/deleteCategory")
    @Transactional
    public Result deleteCategory(@RequestBody IdDTO dto) {
        List<Category> children = categoryService.list(new QueryWrapper<Category>().in("parent", dto.getIds()));
        if (CollectionUtil.isNotEmpty(children)) {
            throw new ResultException(ResultEnum.CHILDREN_EXISTS);
        }
        roleCategoryService.remove(new QueryWrapper<RoleCategory>().in("category_id", dto.getIds()));
        List<Integer> movieIds = movieService.list(new QueryWrapper<Movie>()
                .in("mv_type", dto.getIds())).stream().map(Movie::getId).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(movieIds)) {
            IdDTO movieDto = new IdDTO();
            movieDto.setIds(movieIds);
            movieService.deleteMovie(movieDto);
        }
        return ResultUtil.trueOrFalse(categoryService.removeByIds(dto.getIds()));
    }

}