package com.xuan.crow.restful.controller;

import com.xuan.crow.biz.util.CheckUtil;
import com.xuan.crow.restful.domain.form.BaseForm;

/**
 * 所有Controller的基类
 * <p>
 * Created by xuan on 17/3/19.
 */
public class BaseController {

    /**
     * 基本参数的校验,token暂时不处理,以后肯定要处理的
     *
     * @param baseForm
     */
    protected void checkBaseForm(BaseForm baseForm) {
        CheckUtil.checkNull(baseForm.getAppId(), "baseForm.appId");
        CheckUtil.checkEmpty(baseForm.getOsType(), "baseForm.osType");
    }

}
