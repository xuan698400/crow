package com.xuan.crow.biz.service.impl;

import com.xuan.crow.biz.service.AppMessageService;
import com.xuan.crow.biz.util.CheckUtil;
import com.xuan.crow.common.msg.CMessage;
import com.xuan.crow.common.msg.enums.MessageContentTypeEnum;
import org.springframework.stereotype.Service;

/**
 * 消息服务实现
 * <p>
 * Created by xuan on 17/6/30.
 */
@Service
public class AppMessageServiceImpl implements AppMessageService {

    @Override
    public int add(CMessage message) {
        CheckUtil.checkNull(message, "message");
        CheckUtil.checkEmpty(message.getFromId(), "message.fromId");
        CheckUtil.checkEmpty(message.getFromType(), "message.fromType");
        CheckUtil.checkEmpty(message.getToId(), "message.toId");
        CheckUtil.checkEmpty(message.getToType(), "message.toType");
        CheckUtil.checkEmpty(message.getMessageContentType(), "message.messageContentType");
        String cType = message.getMessageContentType();
        if (MessageContentTypeEnum.TEXT.eq(cType)) {

        } else if (MessageContentTypeEnum.IMG.eq(cType)) {

        } else if (MessageContentTypeEnum.VIOCE.eq(cType)) {

        } else if (MessageContentTypeEnum.VIDEO.eq(cType)) {

        }

        return 0;
    }

}
