package com.spark.platform.adminbiz.service.dept.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spark.platform.adminapi.entity.dept.Dept;
import com.spark.platform.adminbiz.dao.dept.DeptDao;
import com.spark.platform.adminbiz.service.dept.DeptService;
import com.spark.platform.common.utils.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wangdingfeng
 * @Date: 2020/3/20 22:34
 * @Description:
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptDao,Dept> implements DeptService {


    @Override
    public List<Dept> list(Dept dept) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        if(null == dept && StringUtils.isNotBlank(dept.getFullName())){
            queryWrapper.like("fullName",dept.getFullName());
            return super.baseMapper.selectList(queryWrapper);
        }
        return (List<Dept>) TreeUtils.toTree(super.baseMapper.selectList(queryWrapper),Dept.class);
    }
}
