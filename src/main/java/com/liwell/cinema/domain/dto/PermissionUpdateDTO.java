package com.liwell.cinema.domain.dto;

import com.liwell.cinema.domain.enums.LayoutEnum;
import com.liwell.cinema.domain.enums.PermissionTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Description:
 *
 * @author Li
 * @date Created on 2023/8/27
 */
@Data
public class PermissionUpdateDTO {

    private Integer parentId;

    @NotNull(message = "菜单/权限id不能为空")
    private Integer id;

    @NotNull(message = "菜单/权限名称不能为空")
    private String name;

    private String code;

    private String path;

    private String icon;

    private LayoutEnum layout;

    private String component;

    @NotNull(message = "显示状态不能为空")
    private Boolean display;

    @NotNull(message = "状态不能为空")
    private Boolean enable;

    private Boolean keepAlive;

    @NotNull(message = "类型不能为空")
    private PermissionTypeEnum type;

}
