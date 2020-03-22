# spark-platform
spark 平台

- 基于 Spring Cloud Hoxton 、Spring Boot 2.2、 OAuth2 的RBAC权限管理系统  
- 基于数据驱动视图的理念封装 element-ui，即使没有 vue 的使用经验也能快速上手  
- 前后端分离架构，客户端和服务端纯Token交互；
- 认证服务器与资源服务器分离，方便接入自己的微服务系统；

待开发功能
- 字典管理
- 工作流
- 日志功能

### 项目地址
 平台  | spark-platform（后端）|spark-admin（前端）
---|---|---
GitHub | [https://github.com/wangdingfeng/spark-platform](https://github.com/wangdingfeng/spark-platform)|[]()
Gitee  | [https://gitee.com/dreamfeng/spark-platform](https://gitee.com/dreamfeng/spark-platform)|[https://gitee.com/dreamfeng/spark-admin](https://gitee.com/dreamfeng/spark-admin)

### 演示地址

演示地址：[http://www.sparkplatform.cn/](http://www.sparkplatform.cn/)
演示环境账号密码：
账号 | 密码| 权限
---|---|---
admin | 123456 | 注册账户，拥有除删除权限外的所有权限


依赖 | 版本
---|---
Spring Boot |  2.2.0.RELEASE 
Spring Cloud | Hoxton.RC1   
Spring Security | 5.1.6.RELEASE
Mybatis Plus | 3.2.0
Spring  boot admin | 2.2.0
Security Jwt | 1.0.10.RELEASE

#### 模块说明
```lua
spark-platform 
├── spark-auth -- 授权服务 oauth2
└── spark-common -- 系统公共模块 
     ├── spark-common-base -- 基本公共类
     ├── spark-common-config -- 公共配置类
     ├── spark-common-feigh -- 公共feigh类
     ├── spark-common-security -- 安全工具类
     └── spark-common-utils -- 工具类
├── spark-gateway -- Spring Cloud Gateway网关
├── spark-eureka -- Spring Cloud eureka注册中心
├── spark-control -- Spring Boot Admin监控
└── spark-admin -- 通用用户权限管理模块
     └── spark-admin-api -- 通用用户权限管理系统公共api模块
     └── spark-admin-biz -- 通用用户权限管理系统业务处理模块
```

