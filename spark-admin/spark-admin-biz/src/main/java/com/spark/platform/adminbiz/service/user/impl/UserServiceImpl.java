package com.spark.platform.adminbiz.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spark.platform.common.base.constants.GlobalsConstants;
import com.spark.platform.common.utils.HttpCallOtherInterfaceUtils;
import com.spark.platform.adminapi.entity.user.User;
import com.spark.platform.adminapi.vo.UserVo;
import com.spark.platform.adminbiz.dao.user.UserDao;
import com.spark.platform.adminbiz.service.user.UserService;
import com.spark.platform.common.base.exception.CommonException;
import com.spark.platform.common.security.properties.SecurityOAuth2ClientProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: LHL
 * @ProjectName: sophia_scaffolding
 * @Package: com.scaffolding.sophia.admin.biz.service.user.impl
 * @ClassName: UserServiceImpl
 * @Date: 2019/11/5 09:19
 * @Description:
 * @Version: 1.0
 */
@Service("userService")
public class UserServiceImpl  extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Value("${gateway.url}")
    private String url;

    @Autowired
    private SecurityOAuth2ClientProperties securityOAuth2ClientProperties;

    @Override
    public User loadUserByUserName(String username){
        return userDao.findByUserName(username);
    }

    @Override
    @Cacheable(value= GlobalsConstants.REDIS_USER_CACHE,unless = "#result == null", key="T(com.spark.platform.common.base.constants.GlobalsConstants).USER_KEY_PREFIX.concat(T(String).valueOf(#userId))")
    public User loadUserByUserId(Long userId){
        return userDao.findByUserId(userId);
    }


    @Override
    public List<UserVo> findUserVoList(String username) {
        return userDao.findUserVoList(username);
    }


    @Override
    public UserVo loginByPassword(String userName, String password) {
        User user = baseMapper.selectOne(new QueryWrapper<User>().eq("username",userName));
        if (null == user) {
            return null;
        }
        String s;
        //数据库密码是加密了的
        if (passwordEncoder.matches(password, user.getPassword())) {
            s = "?client_id=" + securityOAuth2ClientProperties.getClientId() + "&client_secret=" + securityOAuth2ClientProperties.getClientSecret() + "&grant_type=password&scope=all&username=" + userName + "&password=" + password;
            String sr = HttpCallOtherInterfaceUtils.callOtherInterface(url, "/auth/oauth/token" + s);
            Map srmap = JSON.parseObject(sr);
            if (null == srmap ) {
                throw new CommonException("认证失败:"+sr);
            }
            String access_token;
            if(StringUtils.isEmpty((String) srmap.get("access_token"))){
                access_token = (String) srmap.get("value");
            }else {
                access_token = (String) srmap.get("access_token");
            }
            UserVo vo = new UserVo();
            BeanUtils.copyProperties(user,vo);
            vo.setToken(access_token);
            return vo;
        }
        return null;
    }

    @Override
    public IPage findPage(User user, Page page) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        if(null !=user && StringUtils.isNotBlank(user.getUsername())){
            wrapper.eq("username",user.getUsername());
        }
        return super.page(page,wrapper);
    }
}