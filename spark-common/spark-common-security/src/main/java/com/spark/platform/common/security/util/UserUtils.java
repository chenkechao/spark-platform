package com.spark.platform.common.security.util;

import com.spark.platform.common.security.model.LoginUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.common.security.util
 * @ClassName: UserUtils
 * @Description: 用户工具类
 * @Version: 1.0
 */
public class UserUtils {

    public static LoginUser getLoginUser() {
        return (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
