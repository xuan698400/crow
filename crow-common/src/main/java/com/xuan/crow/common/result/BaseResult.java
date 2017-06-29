package com.xuan.crow.common.result;

import java.util.Date;

/**
 * 返回结果的基类
 * <p>
 * Created by xuan on 17/3/19.
 */
public class BaseResult {

    /**
     * 返回代码值,系统code,请看枚举CodeEnum
     */
    private int code;

    /**
     * 业务code,由使用方自己定
     */
    private String bizCode;

    /**
     * 时间戳
     */
    private long serverTime = new Date().getTime();

    /**
     * 提示
     */
    private String message;

    /**
     * 结果
     */
    private Object result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
