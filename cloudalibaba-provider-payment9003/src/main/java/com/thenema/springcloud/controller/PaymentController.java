package com.thenema.springcloud.controller;

import com.thenema.springcloud.entities.CommonResult;
import com.thenema.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author xiaoxiang
 * @data 2022/3/19 10:11
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long , Payment> hashMap = new HashMap<Long, Payment>();

    static {
        hashMap.put(1L,new Payment(1L,"11"));
        hashMap.put(2L,new Payment(2L,"22"));
        hashMap.put(3L,new Payment(3L,"33"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> PaymentSQL(@PathVariable("id")Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200,"from mysql,serverPort:"+serverPort,payment);
        return result;
    }
}
