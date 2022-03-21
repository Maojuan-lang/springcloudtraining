package com.thenema.springcloud.service.impl;

import com.thenema.springcloud.dao.PaymentDao;
import com.thenema.springcloud.entities.Payment;
import com.thenema.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiaoxiang
 * @data 2022/2/21 1:49
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    }
}
