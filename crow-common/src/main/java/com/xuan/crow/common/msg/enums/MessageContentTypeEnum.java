package com.xuan.crow.common.msg.enums;

/**
 * 消息内容类型
 * <p>
 * Created by xuan on 17/6/30.
 */
public enum MessageContentTypeEnum {
    TEXT("TEXT", "文本"),
    IMG("IMG", "图片"),
    VIOCE("VIOCE", "语音"),
    VIDEO("VIDEO", "视频");

    private String code;
    private String msg;

    MessageContentTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 相等比较
     *
     * @param code
     * @return
     */
    public boolean eq(String code){
        if(null == code || code.length() <= 0){
            return false;
        }
        return code.equals(this.code);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
