package com.spark.platform.common.base.constants;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.common.base.constants
 * @ClassName: BizConstants
 * @Description: 系统常量
 * @Version: 1.0
 */
public class BizConstants {
    /** 是否 */
    public static final Integer YES = 1;
    public static final Integer NO = 0;
    /** 用户状态 */
    //用户状态：正常
    public static final Integer USER_STATUS_NORMAL = 1;
    //用户状态：禁用
    public static final Integer USER_STATUS_UNUSED = 0;
    //用户状态：锁定
    public static final Integer USER_STATUS_LOCKED = 2;
    //用户状态：过期
    public static final Integer USER_STATUS_EXPIRED = 3;
    /**
     * 文件绑定状态 0  未绑定 1 绑定
     */
    public static final String FILE_STATUS_NO_BIND = "0";

    public static final String FILE_STATUS_BIND = "1";


}
