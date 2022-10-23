package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment !=null){
            return new CommonResult(200,"插入数据库成功端口号："+serverPort,payment);
        }else {
            return new CommonResult(444,"插入数据库失败端口号："+serverPort,null);
        }

    }

    @GetMapping(value = "/payment/1b")
    public String getPaymentLB(){
        return serverPort;
    }

}
