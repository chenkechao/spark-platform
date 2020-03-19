package com.spark.platform.adminbiz.service.role.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spark.platform.adminapi.entity.role.Role;
import com.spark.platform.adminbiz.dao.role.RoleDao;
import com.spark.platform.adminbiz.service.role.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.service.role.impl
 * @ClassName: RoleServiceImpl
 * @Date: 2019/11/5 09:28
 * @Description:
 * @Version: 1.0
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getRoleByUserId(Long userId) {
        return roleDao.getRoleByUserId(userId);
    }

    @Override
    public IPage findPage(Role role, Page page) {
        QueryWrapper queryWrapper = new QueryWrapper<Role>();
        if(null != role){
            if(StringUtils.isNotBlank(role.getRoleName())){
                queryWrapper.like("roleName",role.getRoleName());
            }
        }
        return roleDao.selectPage(page,queryWrapper);
    }
}
