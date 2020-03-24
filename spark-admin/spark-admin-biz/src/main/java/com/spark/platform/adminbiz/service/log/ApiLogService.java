package com.spark.platform.adminbiz.service.log;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.spark.platform.adminapi.entity.log.ApiLog;

/**
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.service.log
 * @ClassName: ApiLogService
 * @Author: wangdingfeng
 * @Description: 日志Service
 * @Date: 2020/3/24 13:18
 * @Version: 1.0
 */
public interface ApiLogService extends IService<ApiLog> {

    /**
     * 分页数据
     * @param apiLog
     * @param page
     * @return
     */
    IPage findPage(ApiLog apiLog, Page page);
}
