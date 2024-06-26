package com.liwell.cinema.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liwell.cinema.domain.constants.Constants;
import com.liwell.cinema.domain.dto.LoginDTO;
import com.liwell.cinema.domain.dto.UserAddDTO;
import com.liwell.cinema.domain.dto.UserPageDTO;
import com.liwell.cinema.domain.dto.UserUpdateDTO;
import com.liwell.cinema.domain.entity.Role;
import com.liwell.cinema.domain.entity.User;
import com.liwell.cinema.domain.entity.UserRole;
import com.liwell.cinema.domain.enums.ResultEnum;
import com.liwell.cinema.domain.enums.StateEnum;
import com.liwell.cinema.domain.vo.LoginVO;
import com.liwell.cinema.domain.vo.UserGetVO;
import com.liwell.cinema.domain.vo.UserPageVO;
import com.liwell.cinema.exception.ResultException;
import com.liwell.cinema.helper.RedisHelper;
import com.liwell.cinema.mapper.UserMapper;
import com.liwell.cinema.service.RoleService;
import com.liwell.cinema.service.UserRoleService;
import com.liwell.cinema.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author Li
 * @date Created on 2023/3/17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RedisHelper redisHelper;

    @Override
    public LoginVO login(LoginDTO dto) {
        User user = baseMapper.selectOne(new QueryWrapper<User>()
                .eq("username", dto.getUsername()).eq("state", StateEnum.VALID));
        if (Objects.isNull(user)) {
            throw new ResultException(ResultEnum.USER_NOT_EXISTS);
        }
        if (StringUtils.isBlank(dto.getCaptcha()) || redisHelper.validCaptcha(dto.getCaptcha())) {
            throw new ResultException(ResultEnum.CAPTCHA_ERROR);
        }
        boolean checkPw = BCrypt.checkpw(dto.getPassword(), user.getPassword());
        if (!checkPw) {
            throw new ResultException(ResultEnum.PWD_ERROR);
        }
        List<Role> roles = baseMapper.listUserRole(user.getId());
        StpUtil.login(user.getId());
        StpUtil.getSession().set(Constants.USERNAME_KEY, user.getUsername());
        StpUtil.getSession().set(Constants.CURRENT_ROLE_KEY, roles.isEmpty() ? "" : roles.get(0).getCode());
        StpUtil.getSession().set(Constants.ROLES_KEY, roles);
        LoginVO loginVO = new LoginVO();
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        loginVO.setToken(tokenInfo.getTokenValue());
        return loginVO;
    }

    @Override
    public LoginVO refreshToken() {
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        StpUtil.login(tokenInfo.getLoginId());
        SaTokenInfo newTokenInfo = StpUtil.getTokenInfo();
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(newTokenInfo.getTokenValue());
        return loginVO;
    }

    @Override
    public void logout() {
        StpUtil.logout();
    }

    @Override
    public List<String> listUserPermission(Integer userId) {
        return baseMapper.listUserPermission(userId);
    }

    @Override
    public List<Role> listUserRole(Integer userId) {
        return baseMapper.listUserRole(userId);
    }

    @Override
    public Boolean addUser(UserAddDTO userAddDTO) {
        List<User> userList = baseMapper.selectList(
                new QueryWrapper<User>().eq("username", userAddDTO.getUsername()));
        if (CollectionUtil.isNotEmpty(userList)) {
            throw new ResultException(ResultEnum.USER_EXISTED);
        }
        User user = BeanUtil.copyProperties(userAddDTO, User.class, "role");
        baseMapper.insert(user);
        if (CollectionUtil.isEmpty(userAddDTO.getRoleIds())) {
            return true;
        }
        List<Role> roles = roleService.list(new QueryWrapper<Role>().in("id", userAddDTO.getRoleIds()));
        for (Role role : roles) {
            UserRole userRole = new UserRole(user.getId(), role.getId());
            userRoleService.save(userRole);
        }
        return true;
    }

    @Override
    public Page<UserPageVO> pageUser(UserPageDTO dto) {
        return baseMapper.pageUser(dto);
    }

    @Override
    public UserGetVO getUser(Integer id) {
        User user = baseMapper.selectById(id);
        if (Objects.isNull(user)) {
            throw new ResultException(ResultEnum.DATA_NOT_EXIST);
        }
        UserGetVO userGetVO = BeanUtil.copyProperties(user, UserGetVO.class);
        List<Role> roles = baseMapper.listUserRole(id);
        if (CollectionUtil.isNotEmpty(roles)) {
            userGetVO.setCurRole(roles.get(0));
            userGetVO.setRoles(roles);
        }
        return userGetVO;
    }

    @Override
    @Transactional
    public Boolean updateUser(UserUpdateDTO dto) {
        User user = baseMapper.selectById(dto.getId());
        if (Objects.isNull(user)) {
            throw new ResultException(ResultEnum.DATA_NOT_EXIST);
        }
        if (StringUtils.isNotBlank(dto.getPassword())) {
            String newPw = BCrypt.hashpw(dto.getPassword());
            dto.setPassword(newPw);
        }
        baseMapper.updateUser(dto);
        if (CollectionUtil.isEmpty(dto.getRoleIds())) {
            return userRoleService.lambdaUpdate().eq(UserRole::getUserId, dto.getId()).remove();
        }
        List<Integer> existedRoleIds = userRoleService.lambdaQuery()
                .select(UserRole::getRoleId)
                .eq(UserRole::getUserId, dto.getId())
                .list().stream()
                .map(UserRole::getRoleId).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(existedRoleIds)) {
            List<Integer> deletedRole = existedRoleIds.stream().filter(
                    (item) -> !dto.getRoleIds().contains(item)).collect(Collectors.toList());
            if (!deletedRole.isEmpty()) {
                userRoleService.lambdaUpdate()
                        .eq(UserRole::getUserId, dto.getId())
                        .in(UserRole::getRoleId, deletedRole)
                        .remove();
            }
        }
        List<UserRole> addUserRoles = dto.getRoleIds().stream()
                .filter((item) -> !existedRoleIds.contains(item))
                .map(roleId -> new UserRole(dto.getId(), roleId))
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(addUserRoles)) {
            userRoleService.saveBatch(addUserRoles);
        }
        return true;
    }

    @Override
    public Pair<String, ICaptcha> createCaptcha() {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(80, 40, 4, 4);
        String key = UUID.randomUUID().toString(true);
        Pair<String, ICaptcha> pair = Pair.of(key, captcha);
        redisHelper.cacheCaptcha(pair.getKey());
        return pair;
    }

}
