package com.xuan.crow.common.enums;

import java.text.MessageFormat;

/**
 * 错误码基类
 * <p>
 * Created by xuan on 17/6/21.
 */
public enum BaseErrorEnum {
    UNKNOWN("ER000", "未知错误.e={0}"),
    PARAM_IS_NULL("ER001", "参数NULL错误.参数名={0}"),
    DB_OPERATE_ERROR("ER002", "更新数据库错误"),
    PARAM_VALUE_ERROR("ER003", "参数值错误.参数:{0}={1}");

    private String bizCode;
    private String errorMsg;

    BaseErrorEnum(String bizCode, String errorMsg) {
        this.bizCode = bizCode;
        this.errorMsg = errorMsg;
    }

    public String getBizCode() {
        return bizCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 构建错误信息
     *
     * @param params
     * @return
     */
    public String buildMsg(Object... params) {
        String msg = "[" + this.bizCode + "]";
        if (null != params) {
            msg += MessageFormat.format(errorMsg, params);
        } else {
            msg += msg;
        }
        return msg;
    }

}
