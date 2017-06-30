package com.xuan.crow.common.enums;

/**
 * 端类型
 * <p>
 * Created by xuan on 17/6/30.
 */
public enum OsTypeEnum {

    IOS("IOS", "IOS"),
    ANDROID("ANDROID", "ANDROID"),
    PC("PC", "PC"),
    H5("H5", "H5"),
    UNKNOWN("UNKNOWN", "UNKNOWN");

    private String code;
    private String msg;

    OsTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static OsTypeEnum of(String code) {
        for (OsTypeEnum osTypeEnum : values()) {
            if (osTypeEnum.getCode().equals(code)) {
                return osTypeEnum;
            }
        }
        return UNKNOWN;
    }

}
