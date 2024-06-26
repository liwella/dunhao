package com.liwell.cinema.domain.dto;

import com.liwell.cinema.domain.enums.SexEnum;
import com.liwell.cinema.domain.enums.StateEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Description:
 *
 * @author Li
 * @date Created on 2023/8/26
 */
@Data
public class UserUpdateDTO {

    @NotNull(message = "用户id不能为空")
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String avatar;

    private SexEnum sex;

    private StateEnum state;

    private List<Integer> roleIds;

}
