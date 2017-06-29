package com.xuan.crow.biz.util;

import com.xuan.crow.common.enums.BaseErrorEnum;
import com.xuan.crow.common.exception.CrowException;

/**
 * 一些基本校验工具类
 * <p>
 * Created by xuan on 17/6/29.
 */
public abstract class CheckUtil {

    /**
     * 校验对象空
     *
     * @param obj
     */
    public static void checkNull(Object obj, String paramName) {
        if (null == obj) {
            throw new CrowException(BaseErrorEnum.PARAM_IS_NULL.getBizCode(), BaseErrorEnum.PARAM_IS_NULL.buildMsg(paramName));
        }
    }

    /**
     * 校验字符串空
     *
     * @param str
     * @param paramName
     */
    public static void checkEmpty(String str, String paramName) {
        if (null == str || str.length() <= 0) {
            throw new CrowException(BaseErrorEnum.PARAM_IS_NULL.getBizCode(), BaseErrorEnum.PARAM_IS_NULL.buildMsg(paramName));
        }
    }

    /**
     * 校验数据库操作
     *
     * @param result
     */
    public static void checkDbSuccess(int result) {
        if (result < 1) {
            throw new CrowException(BaseErrorEnum.DB_OPERATE_ERROR.getBizCode(), BaseErrorEnum.PARAM_IS_NULL.buildMsg(null));
        }
    }

}
