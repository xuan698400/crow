package com.xuan.crow.restful.domain.form;

/**
 * 所有接口都会带上这个请求参数
 * <p>
 * Created by xuan on 17/6/30.
 */
public class BaseForm {
    /**
     * 应用标志
     */
    private String appId;

    /**
     * 登录令牌(除了token.json接口没有,其他接口都要求有)
     */
    private String token;

    /**
     * 表示登录平台
     */
    private String osType;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

}
