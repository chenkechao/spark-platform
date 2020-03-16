package com.spark.platform.auth;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.spark.platform.adminapi.feign.client")
@ComponentScan(basePackages = {"com.spark.platform"})
@RestController
@EnableSwagger2Doc
public class SparkAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkAuthApplication.class, args);
    }

}
