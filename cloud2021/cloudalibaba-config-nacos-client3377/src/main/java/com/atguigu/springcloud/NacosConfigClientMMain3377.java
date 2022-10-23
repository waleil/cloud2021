package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: csx
 * @Date: 2021/8/8 16:55
 * @Description:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMMain3377.class,args);
    }
}
