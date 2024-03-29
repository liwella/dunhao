package com.liwell.cinema.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liwell.cinema.domain.dto.IdDTO;
import com.liwell.cinema.domain.dto.MvAddDTO;
import com.liwell.cinema.domain.dto.MvPageDTO;
import com.liwell.cinema.domain.entity.Movie;
import com.liwell.cinema.domain.entity.Playlist;
import com.liwell.cinema.domain.entity.UserRole;
import com.liwell.cinema.domain.enums.ResultEnum;
import com.liwell.cinema.domain.vo.MovieDetailVO;
import com.liwell.cinema.domain.vo.MvPageVO;
import com.liwell.cinema.exception.ResultException;
import com.liwell.cinema.mapper.MovieMapper;
import com.liwell.cinema.mapper.PlaylistMapper;
import com.liwell.cinema.mapper.UserRoleMapper;
import com.liwell.cinema.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Description:
 *
 * @author Li
 * @date Created on 2023/1/24
 */
@Service
@Slf4j
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

    @Autowired
    private PlaylistMapper playlistMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 分页列表
     * @param mvPageDTO
     * @return
     */
    @Override
    public Page<MvPageVO> pageMovie(MvPageDTO mvPageDTO) {
        Integer roleId = 2;
        if (StpUtil.isLogin()) {
            Integer userId = StpUtil.getLoginIdAsInt();
            roleId = userRoleMapper.selectOne(new QueryWrapper<UserRole>().eq("user_id", userId)).getRoleId();
        }
        mvPageDTO.setRoleId(roleId);
        return baseMapper.pageMovie(mvPageDTO);
    }

    /**
     * 获取影片详情
     * @param dto
     * @return
     */
    @Override
    public MovieDetailVO getMovieDetail(IdDTO dto) {
        MovieDetailVO detailVO = baseMapper.getMovieDetail(dto);
        if (detailVO == null) {
            throw new ResultException(ResultEnum.DATA_NOT_EXIST);
        }
        return detailVO;
    }

    @Override
    public Boolean addOrUpdate(MvAddDTO dto) {
        baseMapper.addOrUpdate(dto);
        return true;
    }

    @Override
    public Boolean deleteMovie(IdDTO dto) {
        if (Objects.nonNull(dto.getId())) {
            baseMapper.deleteById(dto.getId());
            playlistMapper.delete(new QueryWrapper<Playlist>().eq("movie_id", dto.getId()));
            return true;
        }
        if (CollectionUtil.isNotEmpty(dto.getIds())) {
            baseMapper.delete(new QueryWrapper<Movie>().in("id", dto.getIds()));
            playlistMapper.delete(new QueryWrapper<Playlist>().in("movie_id", dto.getIds()));
            return true;
        }
        throw new ResultException(ResultEnum.PARAMETER_ERROR);
    }

    @Override
    public List<Integer> listNonSourceMovie() {
        return baseMapper.listNonSourceMovie();
    }

}
