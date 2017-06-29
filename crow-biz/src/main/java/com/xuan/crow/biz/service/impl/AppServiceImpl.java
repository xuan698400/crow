package com.xuan.crow.biz.service.impl;

import com.xuan.crow.biz.dao.AppMapper;
import com.xuan.crow.biz.domain.dto.AppDTO;
import com.xuan.crow.biz.domain.entity.App;
import com.xuan.crow.biz.service.AppService;
import com.xuan.crow.biz.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 应用Service实现
 * <p>
 * Created by xuan on 17/6/29.
 */
@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppMapper appMapper;

    @Override
    public Long add(AppDTO appDTO, String operator) {
        CheckUtil.checkNull(appDTO, "appDTO");
        CheckUtil.checkEmpty(appDTO.getSecret(), "appDTO.secret");
        CheckUtil.checkNull(appDTO.getName(), "appDTO.name");
        CheckUtil.checkEmpty(operator, "operator");
        //
        App app = AppDTO.buildEntityFromDTO(appDTO);
        app = AppDTO.fillForAdd(app, operator);
        appMapper.insert(app);
        return app.getId();
    }

    @Override
    public void updateById(AppDTO appDTO, String operator) {
        CheckUtil.checkNull(appDTO, "appDTO");
        CheckUtil.checkNull(appDTO.getId(), "appDTO.id");
        CheckUtil.checkEmpty(appDTO.getSecret(), "appDTO.secret");
        CheckUtil.checkNull(appDTO.getName(), "appDTO.name");
        CheckUtil.checkEmpty(operator, "operator");
        //
        App app = AppDTO.buildEntityFromDTO(appDTO);
        app = AppDTO.fillForModify(app, operator);
        int result = appMapper.updateByPrimaryKeySelective(app);
        CheckUtil.checkDbSuccess(result);
    }

    @Override
    public void deleteById(Long id, String operator) {
        CheckUtil.checkNull(id, "id");
        CheckUtil.checkEmpty(operator, "operator");
        //
        App app = new App();
        app.setId(id);
        app.setIsDeleted(1);
        app = AppDTO.fillForModify(app, operator);
        int result = appMapper.deleteById(app);
        CheckUtil.checkDbSuccess(result);
    }

    @Override
    public AppDTO getById(Long id) {
        CheckUtil.checkNull(id, "id");
        //
        App app = appMapper.selectByPrimaryKey(id);
        return AppDTO.buildDTOFromEntity(app);
    }

}
