package com.spatk.platform.common.log.aspect;

import cn.hutool.core.util.URLUtil;
import com.spark.platform.adminapi.entity.log.ApiLog;
import com.spark.platform.adminapi.feign.client.ApiLogClient;
import com.spark.platform.common.utils.AddressUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @ProjectName: spark-platform
 * @Package: com.spatk.platform.common.log.aspect
 * @ClassName: LogAspect
 * @Author: wangdingfeng
 * @Description: 日志切面
 * @Date: 2020/3/24 12:59
 * @Version: 1.0
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Autowired
    private ApiLogClient apiLogClient;

    @Pointcut("execution(public * com.spark.platform.*.controller.*(..) )")
    public void log() {

    }

    /**
     * 方法执行前
     * @param joinpoint [参数说明]
     */
    @Before("log()")
    public void before(JoinPoint joinpoint) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String operation = request.getMethod();
        try {
            ApiLog apiLog = new ApiLog();
            apiLog.setCreateTime(LocalDateTime.now());
            apiLog.setCreator(getUsername());
            apiLog.setParams(Arrays.toString(joinpoint.getArgs()));
            String className = joinpoint.getTarget().getClass().getName();
            apiLog.setMethod(className + "." + operation);
            apiLog.setUrl(URLUtil.getPath(request.getRequestURI()));
            String ip = AddressUtils.getIpAddress(request);
            apiLog.setIp(ip);
            apiLog.setAddress(AddressUtils.getCityInfo(ip));
            apiLogClient.save(apiLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取用户名称
     *
     * @return username
     */
    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getName();
    }


    /**
     * 方法执行后
     * @param joinpoint [参数说明]
     * @return void [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    @After("log()")
    public void after(JoinPoint joinpoint) {

    }

}
