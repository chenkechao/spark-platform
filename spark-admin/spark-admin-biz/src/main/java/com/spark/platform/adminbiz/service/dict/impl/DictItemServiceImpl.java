package com.spark.platform.adminbiz.service.dict.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spark.platform.adminapi.entity.dict.DictItem;
import com.spark.platform.adminbiz.dao.dept.DictItemDao;
import com.spark.platform.adminbiz.service.dict.DictItemService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.service.dict.impl
 * @ClassName: DictItemServiceImpl
 * @Author: wangdingfeng
 * @Description:
 * @Date: 2020/3/26 10:18
 * @Version: 1.0
 */
@Service
public class DictItemServiceImpl extends ServiceImpl<DictItemDao, DictItem> implements DictItemService {
}
