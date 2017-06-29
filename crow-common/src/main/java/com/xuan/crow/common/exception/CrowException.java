package com.xuan.crow.common.exception;

/**
 * 通用异常
 * <p>
 * Created by xuan on 17/2/22.
 */
public class CrowException extends RuntimeException {
    private static final long serialVersionUID = -1282268289535528399L;

    /**
     * 错误业务码
     */
    private String bizCode;

    /**
     * 统一错误码
     *
     * @param bizCode
     * @param message
     */
    public CrowException(String bizCode, String message) {
        super(message);
        this.bizCode = bizCode;
    }

    /**
     * 获取错误业务码
     *
     * @return
     */
    public String getBizCode() {
        return bizCode;
    }

    /**
     * 异常处理，优化速度
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
