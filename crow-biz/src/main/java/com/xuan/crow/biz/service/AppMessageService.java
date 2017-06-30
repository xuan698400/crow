package com.xuan.crow.biz.service;

import com.xuan.crow.common.msg.CMessage;

/**
 * 消息服务
 * <p>
 * Created by xuan on 17/6/30.
 */
public interface AppMessageService {

    /**
     * 添加一条消息
     *
     * @param message
     * @return
     */
    int add(CMessage message);
}
