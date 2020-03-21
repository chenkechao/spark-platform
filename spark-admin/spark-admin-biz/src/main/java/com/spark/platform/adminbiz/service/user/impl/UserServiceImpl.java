package com.spark.platform.adminbiz.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spark.platform.adminapi.entity.user.UserRole;
import com.spark.platform.adminbiz.dao.user.UserRoleDao;
import com.spark.platform.common.base.constants.GlobalsConstants;
import com.spark.platform.common.utils.HttpCallOtherInterfaceUtils;
import com.spark.platform.adminapi.entity.user.User;
import com.spark.platform.adminapi.vo.UserVo;
import com.spark.platform.adminbiz.dao.user.UserDao;
import com.spark.platform.adminbiz.service.user.UserService;
import com.spark.platform.common.base.exception.CommonException;
import com.spark.platform.common.security.properties.SecurityOAuth2ClientProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.service.user.impl
 * @ClassName: UserServiceImpl
 * @Description:
 * @Version: 1.0
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserRoleDao userRoleDao;


    @Value("${gateway.url}")
    private String url;

    @Autowired
    private SecurityOAuth2ClientProperties securityOAuth2ClientProperties;

    @Override
    public User loadUserByUserName(String username) {
        return super.baseMapper.findByUserName(username);
    }

    @Override
    @Cacheable(value = GlobalsConstants.REDIS_USER_CACHE, unless = "#result == null", key = "T(com.spark.platform.common.base.constants.GlobalsConstants).USER_KEY_PREFIX.concat(T(String).valueOf(#userId))")
    public User loadUserByUserId(Long userId) {
        return super.baseMapper.findByUserId(userId);
    }


    @Override
    public UserVo loginByPassword(String userName, String password) {
        User user = baseMapper.selectOne(new QueryWrapper<User>().eq("username", userName));
        if (null == user) {
            return null;
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(password, user.getPassword())) {
            StringBuilder authUrl = new StringBuilder(GlobalsConstants.OAUTH_TOKEN_URL);
            authUrl.append("?client_id=").append(securityOAuth2ClientProperties.getClientId()).append("&client_secret=").append(securityOAuth2ClientProperties.getClientSecret())
                    .append("&grant_type=password&scope=all&username=").append(userName).append("&password=").append(password);
            String sr = HttpCallOtherInterfaceUtils.callOtherInterface(url, authUrl.toString());
            Map srmap = JSON.parseObject(sr);
            if (null == srmap) {
                throw new CommonException("认证失败:" + sr);
            }
            String access_token;
            if (StringUtils.isEmpty((String) srmap.get("access_token"))) {
                access_token = (String) srmap.get("value");
            } else {
                access_token = (String) srmap.get("access_token");
            }
            UserVo vo = new UserVo();
            BeanUtils.copyProperties(user, vo);
            vo.setToken(access_token);
            return vo;
        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        //修改用户角色
        for (Long roleId : user.getRoles()) {
            int i = userRoleDao.deleteByUserId(user.getId());
            log.info("删除用户：{}角色:{}个", user.getId(), i);
            userRoleDao.insert(new UserRole(roleId, user.getId()));
        }
        return super.updateById(user);
    }

    @Override
    public IPage findPage(User user, Page page) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        if (null != user) {
            if (StringUtils.isNotBlank(user.getUsername())) {
                wrapper.like("username", user.getUsername());
            }
            if (null != user.getStatus()) {
                wrapper.eq("status", user.getStatus());
            }
            if (null != user.getNickname()) {
                wrapper.like("nickname", user.getNickname());
            }
        }
        return super.page(page, wrapper);
    }

    @Override
    public void updatePassword(Long userId, String password) {
        User user = this.loadUserByUserId(userId);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(password, user.getPassword())) {
            throw new CommonException("新密码与旧密码重复，请修改新密码");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        super.updateById(user);
    }

    @Override
    public List<Long> findRolIdsByUserId(Long userId) {
        return userRoleDao.selectList(new QueryWrapper<UserRole>().eq("user_id", userId)).stream().map(UserRole::getRoleId).collect(Collectors.toList());
    }

    @Override
    public boolean save(User entity) {
        //保存密码
        entity.setPassword(new BCryptPasswordEncoder().encode(GlobalsConstants.DEFAULT_USER_PASSWORD));
        //修改用户角色
        for (Long roleId : entity.getRoles()) {
            int i = userRoleDao.deleteByUserId(entity.getId());
            log.info("删除用户：{}角色:{}个", entity.getId(), i);
            userRoleDao.insert(new UserRole(roleId, entity.getId()));
        }
        return super.save(entity);
    }
}