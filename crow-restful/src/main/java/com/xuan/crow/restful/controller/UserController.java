package com.xuan.crow.restful.controller;

import com.xuan.crow.biz.service.AppUserService;
import com.xuan.crow.biz.util.CheckUtil;
import com.xuan.crow.common.result.Result;
import com.xuan.crow.restful.domain.form.BaseForm;
import com.xuan.crow.restful.domain.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 * <p>
 * Created by xuan on 17/6/30.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private AppUserService appUserService;

    @RequestMapping("getToken.json")
    @ResponseBody
    public Result getToken(BaseForm baseForm, UserForm userForm) {
        checkBaseForm(baseForm);
        CheckUtil.checkEmpty(userForm.getUserId(), "userForm.userId");
        //
        String token = appUserService.getToken(
                userForm.getUserId(),
                userForm.getUserName(),
                userForm.getUserLogo(),
                baseForm.getOsType(),
                baseForm.getAppId());
        return Result.obtainSuccessForKv("token", token);
    }

}
