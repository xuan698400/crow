package com.xuan.crow.biz.dao;

import com.xuan.crow.biz.domain.entity.AppUser;
import org.apache.ibatis.annotations.Param;

public interface AppUserMapper {
    int insert(AppUser record);

    AppUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppUser record);

    /**
     * 根据userId和osType查询
     *
     * @param userId
     * @param osType
     * @return
     */
    AppUser selectByUserIdAndOsType(@Param("userId") String userId, @Param("osType") String osType, @Param("appId") String appId);

}