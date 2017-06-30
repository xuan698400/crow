package com.xuan.crow.biz.service.impl;

import com.xuan.crow.biz.dao.AppUserMapper;
import com.xuan.crow.biz.domain.Constants;
import com.xuan.crow.biz.domain.entity.AppUser;
import com.xuan.crow.biz.service.AppUserService;
import com.xuan.crow.biz.util.CheckUtil;
import com.xuan.crow.common.enums.OsTypeEnum;
import com.xuan.crow.common.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * AppUserService实现
 *
 * Created by xuan on 17/6/30.
 */
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserMapper appUserMapper;

    @Override
    public String getToken(String userId, String userName, String userLogo, String osType, String appId) {
        CheckUtil.checkEmpty(userId, "userId");
        CheckUtil.checkEmpty(appId, "appId");
        OsTypeEnum osTypeEnum = OsTypeEnum.of(osType);

        //查询用户信息是否存在
        AppUser appUser = appUserMapper.selectByUserIdAndOsType(userId, osTypeEnum.getCode(), appId);
        if(Objects.isNull(appUser)){
            //不存在,新建一个
            appUser = getNewAppUser(userId, userName, userLogo, osTypeEnum.getCode(), appId);
            appUserMapper.insert(appUser);
        }else{
            //存在,更新信息
            appUser.setUserName(userName);
            appUser.setUserLogo(userLogo);
            appUser.setToken(UUIDUtils.uuid());
            appUser.setModifyTime(new Date());
            appUser.setEditor(Constants.OP_GETTOKEN);
            appUserMapper.updateByPrimaryKeySelective(appUser);
        }
        return appUser.getToken();
    }

    private AppUser getNewAppUser(String userId, String userName, String userLogo, String osType, String appId){
        AppUser appUser = new AppUser();
        appUser = new AppUser();
        appUser.setAppId(appId);
        appUser.setUserId(userId);
        appUser.setUserName(userName);
        appUser.setUserLogo(userLogo);
        appUser.setOsType(osType);
        appUser.setToken(UUIDUtils.uuid());
        Date date = new Date();
        appUser.setCreationTime(date);
        appUser.setModifyTime(date);
        appUser.setCreator(Constants.OP_GETTOKEN);
        appUser.setEditor(Constants.OP_GETTOKEN);
        appUser.setIsDeleted(0);
        return appUser;
    }
}
