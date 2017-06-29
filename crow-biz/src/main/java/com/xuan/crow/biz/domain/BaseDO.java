package com.xuan.crow.biz.domain;

import com.xuan.crow.biz.util.NoNullFieldStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * 所有模型的基类
 * <p>
 * Created by xuan on 17/6/29.
 */
public class BaseDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new NoNullFieldStringStyle());
    }
}
