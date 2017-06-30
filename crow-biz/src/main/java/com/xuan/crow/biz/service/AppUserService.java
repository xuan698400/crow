package com.xuan.crow.biz.service;

/**
 * 用户信息
 * <p>
 * Created by xuan on 17/6/30.
 */
public interface AppUserService {

    /**
     * 获取token,如果用户不存在,会自动初始化
     *
     * @param userId
     * @param userName
     * @param userLogo
     * @param osType
     * @param appId
     * @return
     */
    String getToken(String userId, String userName, String userLogo, String osType, String appId);
}
