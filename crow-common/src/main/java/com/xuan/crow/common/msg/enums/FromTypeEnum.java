package com.xuan.crow.common.msg.enums;

/**
 * 发送人类型
 * <p>
 * Created by xuan on 17/6/30.
 */
public enum FromTypeEnum {

    USER("USER", "用户"),
    SYSTEM("SYSTEM", "系统");

    private String code;
    private String msg;

    FromTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
