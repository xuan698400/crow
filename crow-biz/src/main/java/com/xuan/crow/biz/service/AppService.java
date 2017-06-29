package com.xuan.crow.biz.service;

import com.xuan.crow.biz.domain.dto.AppDTO;

/**
 * 应用Service
 * <p>
 * Created by xuan on 17/6/29.
 */
public interface AppService {

    /**
     * 新增
     *
     * @param appDTO
     * @return
     */
    Long add(AppDTO appDTO, String operator);

    /**
     * 根据ID修改
     *
     * @param appDTO
     * @return
     */
    void updateById(AppDTO appDTO, String operator);

    /**
     * 根据ID修改
     *
     * @param id
     * @return
     */
    void deleteById(Long id, String operator);

    /**
     * 根据ID获取
     *
     * @param id
     * @return
     */
    AppDTO getById(Long id);
}
