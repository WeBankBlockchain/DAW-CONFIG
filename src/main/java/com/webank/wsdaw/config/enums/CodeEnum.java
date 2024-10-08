package com.webank.wsdaw.config.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CodeEnum {
    // 0-request success
    TRANSACTION_SUCCESS(0, "操作成功"),

    // 1000-1999: params validate error
    REQUEST_PARAMS_ERROR(1001, "请求参数错误"),
    PASSWORD_ERROR(1002, "用户名或密码错误"),

    EMAIL_EXIST_ERROR(1011, "email already exist"),
    USER_NOT_EXIST_ERROR(1012, "user not exist"),

    // 2000-2999: config
    CONFIG_NOT_EXIST(2001, "请求配置不存在"),

    // 3000-3999: kyc
    SIGN_NOT_PASS(3002, "签名验证不通过"),

    // 6000-6999: db error
    CONFIG_ERROR(6001, "数据库配置错误"),

    // 7000-7999: third service error
    USER_KEY_PAIR_NOT_EXIST(7000, "用户密钥对不存在"),

    // other error
    OPER_FREQUENT_ERROR(8001, "请求验证码太频繁"),
    NOT_GET_CODE_ERROR(8002, "请先获取验证码"),
    CODE_OUT_OF_TIME_ERROR(8003, "验证码已超时，请重新获取"),
    INVALID_CODE(8004, "验证码错误"),

    // 9000-9998: system error
    // 9999-unknown error
    UNKNOWN_ERROR(9999, "系统错误");

    private final int code;
    private final String msg;

    public static CodeEnum getCodeEnum(int code) {
        for (CodeEnum type : CodeEnum.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return UNKNOWN_ERROR;
    }
}
