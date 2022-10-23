package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.Serializable;

/**
 * @Auther: csx
 * @Date: 2021/7/26 16:02
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService, Serializable {
    @Autowired
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
