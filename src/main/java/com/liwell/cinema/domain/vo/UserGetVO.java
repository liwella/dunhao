package com.liwell.cinema.domain.vo;

import com.liwell.cinema.domain.entity.Role;
import com.liwell.cinema.domain.enums.SexEnum;
import com.liwell.cinema.domain.enums.StateEnum;
import lombok.Data;

import java.util.Date;

/**
 * Description:
 *
 * @author Li
 * @date Created on 2023/8/26
 */
@Data
public class UserGetVO {

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String avatar;

    private SexEnum sex;

    private Date createTime;

    private Date updateTime;

    private StateEnum state;

    private Role role;

}
