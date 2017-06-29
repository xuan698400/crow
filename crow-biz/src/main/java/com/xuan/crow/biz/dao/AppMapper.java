package com.xuan.crow.biz.dao;

import com.xuan.crow.biz.domain.entity.App;

public interface AppMapper {
    int insert(App record);

    App selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(App app);

    int deleteById(App app);
}