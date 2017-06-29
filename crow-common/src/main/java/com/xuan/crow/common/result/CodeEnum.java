package com.xuan.crow.common.result;

/**
 * 返回结果状态码
 * <p>
 * CodeEnum Created by xuan on 17/3/19.
 */
public enum CodeEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "服务器未知错误");

    private int    code;
    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static CodeEnum valueOf(int code) {
        CodeEnum result = ERROR;
        for (CodeEnum e : CodeEnum.values()) {
            if (e.getCode() == code) {
                result = e;
            }
        }
        return result;
    }

}
