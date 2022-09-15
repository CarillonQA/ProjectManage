package com.pm.common.enums;

import lombok.Getter;

/**
 * @Description: 类（或接口）是 异常枚举
 * @ClassName: ExceptionEnum
 * @Author: xwt
 * @version: 1.0
 */
@Getter
public enum ExceptionEnum {
    DATA_TRANSFER_ERROR(500, "【数据转换】数据转换出错，目标对象{}构造函数异常"),
    INVALID_PARAM_ERROR(204, "无效的参数传递"),
    INVALID_USERNAME_PASSWORD(403, "无效的用户名或密码"),
    UNAUTHORIZED(403, "TOKEN认证未通过（TOKEN解析失败）"),
    DATA_NOT_FOUND(404, "数据未找到"),
    DATA_PARSING_ANOMALY(500, "数据解析异常"),
    PUBLIC_KEY_READ_FAILED(500, "公钥读取失败"),
    PRIVATE_KEY_READ_FAILED(500, "私钥读取失败"),
    TOKEN_EXPIRED(403, "TOKEN已过期"),
    NO_ACCESS_RIGHTS(403, "没有访问权限"),
    NOT_LOGIN(401, "用户未登录"),
    REPEAT_LOGIN(401, "重复登录"),
    DATA_UPDATE_ERROR(500, "数据更新异常"),
    ;
    private int status;
    private String msg;

    ExceptionEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
