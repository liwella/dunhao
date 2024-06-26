package com.liwell.cinema.domain.enums;

import lombok.Getter;

/**
 * Description:
 *
 * @author Li
 * @date Created on 2023/1/24
 */
@Getter
public enum ResultEnum implements BaseEnum {

    // 通用异常
    SUCCESS(200, "操作成功"),
    FAIL(-1, "操作失败"),
    DATA_NOT_EXIST(1001, "查询数据出错！"),
    PARAMETER_ERROR(1002, "参数错误！"),
    ENUM_VALUE_ERROR(1003, "枚举值不存在"),
    INTERFACE_METHOD_ERROR(1004, "接口不支持的方法"),
    THIRD_INTERFACE_ERROR(1005, "调用第三方接口出错！"),

    // 用户模块
    PWD_ERROR(1101, "用户名或秘密错误！"),
    LOGGING_ERROR(1102, "登录信息错误"),
    PERMISSION_ERROR(1103, "权限不足！"),
    NOT_ROLE_EXCEPTION(1104, "角色不存在"),
    NOT_LOGGING(1105, "用户未登录"),
    USER_EXISTED(1106, "用户名已存在"),
    ROLE_CODE_EXISTS(1107, "角色编码已存在"),
    USER_NOT_EXISTS(1108, "用户不存在"),
    CAPTCHA_ERROR(1109, "验证码错误"),

    // 分类模块
    ALREADY_TOP(1201, "已是最上层/底层节点，无法移动"),
    CHILDREN_EXISTS(1202, "有节点存在子分类未删除，请先删除子分类"),

    // 系统模块
    MENU_CAN_CATEGORY_OR_TOP(1220, "菜单/目录只能为顶层或归属于目录"),
    PERMISSION_ONLY_MENU(1221, "按钮仅能归属于菜单"),

    // 影视模块
    TASK_IN_EXECUTE(1303, "采集源当前有采集任务在执行中，请勿重复执行"),
    TASK_STATE_ERROR(1304, "当前任务状态无法执行"),
    TASK_NOT_EXISTS(1305, "采集任务不存在"),
    SOURCE_CONFIG_NOT_EXISTS(1306, "查询采集源配置不存在"),
    ;

    private Integer value;

    private String description;

    ResultEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

}
