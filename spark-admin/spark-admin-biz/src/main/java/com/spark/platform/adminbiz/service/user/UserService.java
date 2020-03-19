package com.spark.platform.adminbiz.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.spark.platform.adminapi.entity.user.User;
import com.spark.platform.adminapi.vo.UserVo;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.service.user
 * @ClassName: UserService
 * @Description: 用户管理
 * @Version: 1.0
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名称查询用户
     *
     * @param username 用户名
     * @return User
     */
    User loadUserByUserName(String username);

    /**
     * 根据用户id查询用户
     *
     * @param userId 用户id
     * @return User
     */
    User loadUserByUserId(Long userId);
    /**
     * 用户 用户名和密码登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return UserVo
     * */
    UserVo loginByPassword(String userName, String password);

    /**
     * 分页查询数据
     * @param user
     * @param page
     * @return
     */
    IPage findPage(User user, Page page);

    /**
     * 修改密码
     * @param password 新密码
     */
    void updatePassword(Long userId,String password);
}
