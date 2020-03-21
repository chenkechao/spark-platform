package com.spark.platform.adminbiz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spark.platform.adminapi.entity.authority.OauthClientDetails;
import com.spark.platform.adminbiz.service.authority.OauthClientDetailsService;
import com.spark.platform.common.base.support.BaseController;
import com.spark.platform.common.base.support.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.controller
 * @ClassName: AuthorityController
 * @Date: 2019/9/28 13:59
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/authority")
@Api(tags = "Oauht2客户端详情设置")
public class AuthorityController extends BaseController {

    @Autowired
    private OauthClientDetailsService oauthClientDetailsService;


    @GetMapping("/api/info")
    @ApiOperation(value = "根据clientId获取认证客户端详情信息")
    public ApiResponse getOauthClientDetailsByClientId(@RequestParam String clientId) {
        return success(oauthClientDetailsService.findOauthClientDetailsByClientId(clientId));
    }

    @PostMapping("/page")
    @ApiOperation(value = "获取角色列表分页")
    public ApiResponse page(OauthClientDetails oauthClientDetails, Page page){
        return success(oauthClientDetailsService.findPage(oauthClientDetails,page));
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存角色信息")
    public ApiResponse save(@RequestBody OauthClientDetails oauthClientDetails){
        return success(oauthClientDetailsService.save(oauthClientDetails));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新角色信息")
    public ApiResponse update(@RequestBody OauthClientDetails oauthClientDetails){
        return success(oauthClientDetailsService.updateById(oauthClientDetails));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "更新角色信息")
    public ApiResponse delete(@PathVariable Long id){
        return success(oauthClientDetailsService.removeById(id));
    }



}
