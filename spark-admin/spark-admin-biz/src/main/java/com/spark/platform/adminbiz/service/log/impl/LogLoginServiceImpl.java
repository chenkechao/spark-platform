package com.spark.platform.adminbiz.service.log.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spark.platform.adminapi.entity.log.LogLogin;
import com.spark.platform.adminbiz.dao.log.LoginLogDao;
import com.spark.platform.adminbiz.service.log.LogLoginService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录日志 服务实现类
 * </p>
 *
 * @author wangdingfeng
 * @since 2020-04-18
 */
@Service
public class LogLoginServiceImpl extends ServiceImpl<LoginLogDao, LogLogin> implements LogLoginService {

    @Override
    public IPage findPage(Page page, LogLogin loginLog) {
        QueryWrapper wrapper = new QueryWrapper();
        if (null != loginLog) {
            if (StringUtils.isNotBlank(loginLog.getUsername())) {
                wrapper.eq("username", loginLog.getUsername());
            }
        }
        return super.page(page, wrapper);
    }
}
