package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.appinfo.InstanceInfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: csx
 * @Date: 2021/7/26 16:06
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result>0){
            return new CommonResult(200,"插入数据库成功端口号："+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败端口号："+serverPort,null);
        }

    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment !=null){
            return new CommonResult(200,"插入数据库成功端口号："+serverPort,payment);
        }else {
            return new CommonResult(444,"插入数据库失败端口号："+serverPort,null);
        }

    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<ServiceInstance> instancesById = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance :instancesById) {
            log.info(instance.getHost()+"\t"+instance.getServiceId());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/1b")
    public String getPaymentLB(){
        return serverPort;
    }

}
