package com.thenema.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.thenema.springcloud.entities.CommonResult;
import com.thenema.springcloud.entities.Payment;
import com.thenema.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xiaoxiang
 * @data 2022/3/19 11:11
 */
@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
    exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class,id);

        if(id ==4){
            throw new IllegalArgumentException("非法参数异常");
        }else if(result.getData() == null){
            throw new NullPointerException("空指针异常");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable Long id,Throwable throwable){
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"兜底异常内容"+ throwable.getMessage(),payment);
    }

    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException){
        Payment payment = new Payment(id,"null");
        return new CommonResult(555,"blockHandler限流"+blockException.getMessage(),payment);
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }
}
