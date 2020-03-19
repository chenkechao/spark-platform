package com.spark.platform.adminbiz.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.spark.platform.common.base.constants.GlobalsConstants;
import com.spark.platform.common.security.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.config
 * @ClassName: MybatisPlusDefaultMetaObjectHandler
 * @Author: wangdingfeng
 * @Description: mybatis plus 插入更新监听
 * @Version: 1.0
 */
@Slf4j
@Component
public class MybatisPlusDefaultMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入操作
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //获取当前登录账号
        String account = getAccount();
        //放入当前操作者信息
        this.setFieldValByName("creator",account,metaObject);
        this.setFieldValByName("modifier",account,metaObject);
        this.setFieldValByName("createDate",LocalDateTime.now(),metaObject);
        this.setFieldValByName("modifyDate",LocalDateTime.now(),metaObject);
        this.setFieldValByName("delFlag",0,metaObject);
    }

    /**
     * 更新操作
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        //获取当前登录账号
        String account = getAccount();
        this.setFieldValByName("modifier",account,metaObject);
        this.setFieldValByName("modifyDate", LocalDateTime.now(),metaObject);
    }

    /**
     * 获取当前登录账号
     * @return
     */
    private String getAccount(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(null == authentication || null == authentication.getPrincipal()){
            log.info("============当前无登录信息，请注意================");
           return GlobalsConstants.DEFAULT_USER_SYSTEM;
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return loginUser.getUsername();
    }
}
