package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: csx
 * @Date: 2021/8/9 10:26
 * @Description:
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "....testA";
    }

     @GetMapping("/testB")
     public String testB(){
        return "....testB";
    }
     @GetMapping("/testHotKey")
     @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
     public String testHotKey(@RequestParam(value = "p1",required = false) String pq,
                              @RequestParam(value = "p2",required = false)String p2){
        return "....testB";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "----deal_testHotkey";
    }

}
