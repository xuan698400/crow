package com.xuan.crow.common.msg;

/**
 * 消息体
 * <p>
 * Created by xuan on 17/6/30.
 */
public class CMessage {
    private static final long serialVersionUID = 1L;

    /**
     * 消息id
     */
    private String id;

    /**
     * 发送人
     */
    private String fromId;

    /**
     * 发送类型,参考FromTypeEnum
     */
    private String fromType;

    /**
     * 接受人
     */
    private String toId;

    /**
     * 接受类型
     */
    private String toType;

    /**
     * 消息内容类型,参考MessageContentTypeEnum
     */
    private String messageContentType;

    /**
     * 文本消息内容
     */
    private String text;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 语音地址
     */
    private String voiceUrl;

    /**
     * 视频地址
     */
    private String videoUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getToType() {
        return toType;
    }

    public void setToType(String toType) {
        this.toType = toType;
    }

    public String getMessageContentType() {
        return messageContentType;
    }

    public void setMessageContentType(String messageContentType) {
        this.messageContentType = messageContentType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
