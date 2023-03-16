package com.liwell.cinema.domain.entity;

import com.liwell.cinema.domain.enums.RoleEnum;
import com.liwell.cinema.domain.enums.SexEnum;
import com.liwell.cinema.domain.enums.StateEnum;
import lombok.Data;

import java.util.Date;

/**
 * Description:
 *
 * @author Li
 * @date Created on 2023/3/16
 */
@Data
public class User {

    private String username;

    private String password;

    private String phone;

    private String email;

    private String avatar;

    private SexEnum sex;

    private Date createTime;

    private Date updateTime;

    private RoleEnum role;

    private StateEnum state;

}
