package com.xuan.crow.service;

import com.xuan.crow.biz.domain.dto.AppDTO;
import com.xuan.crow.biz.service.AppService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AppService单测
 * <p>
 * Created by xuan on 17/6/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:biz-root.xml"})
public class AppServiceTest {

    @Autowired
    AppService appService;

    @Test
    public void testAdd() {
        AppDTO appDTO = new AppDTO();
        appDTO.setName("我是APP名称");
        appDTO.setSecret("123456");
        appDTO.setRemark("我是说明");
        appService.add(appDTO, "xuan001");
    }

    @Test
    public void testUpdateById() {
        AppDTO appDTO = new AppDTO();
        appDTO.setId(1L);
        appDTO.setName("我是APP名称-被修改");
        appDTO.setSecret("123456-789");
        appDTO.setRemark("我是说明-被修改");
        appService.updateById(appDTO, "xuan002");
    }

    @Test
    public void testDeleteById() {
        appService.deleteById(1L, "xuan003");
    }

    @Test
    public void testGetById() {
        AppDTO appDTO = appService.getById(1L);
        System.out.println("++++++++++appDTO:" + appDTO);
    }

}
