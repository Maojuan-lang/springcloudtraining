package com.thenema.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author xiaoxiang
 * @data 2022/3/10 19:25
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_Timeout";
    }
}
