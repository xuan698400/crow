package com.xuan.crow.biz.domain.json;

/**
 * 消息内容JSON
 * <p>
 * Created by xuan on 17/6/30.
 */
public class MessageJson {
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
