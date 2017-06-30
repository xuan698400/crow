package com.xuan.crow.biz.dao;

import com.xuan.crow.biz.domain.entity.AppMessage;

public interface AppMessageMapper {
    int insert(AppMessage record);
    
    AppMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppMessage record);
}