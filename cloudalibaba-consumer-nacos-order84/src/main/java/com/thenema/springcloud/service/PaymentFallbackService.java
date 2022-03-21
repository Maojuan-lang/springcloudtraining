package com.thenema.springcloud.service;

import com.thenema.springcloud.entities.CommonResult;
import com.thenema.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author xiaoxiang
 * @data 2022/3/19 15:35
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id){
        return new CommonResult<>(444,"服务降级返回",new Payment(id,"errorSerial"));
    }
}
