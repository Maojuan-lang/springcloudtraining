package com.thenema.springcloud.service;

import com.thenema.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiaoxiang
 * @data 2022/2/21 1:49
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
