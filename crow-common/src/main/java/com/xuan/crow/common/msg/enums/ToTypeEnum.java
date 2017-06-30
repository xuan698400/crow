package com.xuan.crow.common.msg.enums;

/**
 * 接受人类型
 * <p>
 * Created by xuan on 17/6/30.
 */
public enum ToTypeEnum {

    USER("USER", "用户"),
    GROUP("GROUP", "群组");

    private String code;
    private String msg;

    ToTypeEnum(String code, String msg) {
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
