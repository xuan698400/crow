package com.xuan.crow.biz.domain.dto;

import com.xuan.crow.biz.domain.BaseDO;
import com.xuan.crow.biz.domain.entity.App;

import java.util.Date;

/**
 * 应用DTO模型
 * <p>
 * Created by xuan on 17/6/29.
 */
public class AppDTO extends BaseDO {
    private static final long serialVersionUID = 1L;

    /**
     * 应用ID
     */
    private Long id;

    /**
     * 秘钥
     */
    private String secret;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注描述
     */
    private String remark;

    private Integer isDeleted;

    private String editor;

    private String creator;

    private Date modifyTime;

    private Date creationTime;

    /**
     * 填充操作人和创建修改时间
     *
     * @param app
     * @param operator
     * @return
     */
    public static App fillForAdd(App app, String operator) {
        Date date = new Date();
        app.setCreationTime(date);
        app.setModifyTime(date);
        app.setCreator(operator);
        app.setEditor(operator);
        app.setIsDeleted(0);
        return app;
    }

    /**
     * 填充操作人和修改时间
     *
     * @param app
     * @param operator
     * @return
     */
    public static App fillForModify(App app, String operator) {
        Date date = new Date();
        app.setModifyTime(date);
        app.setEditor(operator);
        return app;
    }

    /**
     *  构建DTO from Entity
     *
     * @param app
     * @return
     */
    public static AppDTO buildDTOFromEntity(App app) {
        if (app == null) {
            return null;
        }
        AppDTO appDTO = new AppDTO();
        appDTO.setId(app.getId());
        appDTO.setSecret(app.getSecret());
        appDTO.setName(app.getName());
        appDTO.setRemark(app.getRemark());
        appDTO.setIsDeleted(app.getIsDeleted());
        appDTO.setEditor(app.getEditor());
        appDTO.setCreator(app.getCreator());
        appDTO.setModifyTime(app.getModifyTime());
        appDTO.setCreationTime(app.getCreationTime());
        return appDTO;
    }

    /**
     * 构建Entity from DTO
     *
     * @param appDTO
     * @return
     */
    public static App buildEntityFromDTO(AppDTO appDTO) {
        if (appDTO == null) {
            return null;
        }
        App app = new App();
        app.setId(appDTO.getId());
        app.setSecret(appDTO.getSecret());
        app.setName(appDTO.getName());
        app.setRemark(appDTO.getRemark());
        app.setIsDeleted(appDTO.getIsDeleted());
        app.setEditor(appDTO.getEditor());
        app.setCreator(appDTO.getCreator());
        app.setModifyTime(appDTO.getModifyTime());
        app.setCreationTime(appDTO.getCreationTime());
        return app;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
