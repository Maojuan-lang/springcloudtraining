package com.thenema.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaoxiang
 * @data 2022/3/9 21:08
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池："+ Thread.currentThread().getName() + "paymentInfo_OK,id：" + id + "\t";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler" , commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+ Thread.currentThread().getName() + "paymentInfo_Timeout,id：" + id + "\t" + "耗时（s）："+ timeNumber;
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池："+ Thread.currentThread().getName() + "paymentInfo_TimeoutHandler ,id：" + id + "\t"+"出问题了";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if(id<0){
            throw new RuntimeException("****id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t调用成功，流水号为："+serialNumber;
    }
    public String paymentCircuitBreakerFallback(@PathVariable("id")Integer id){
        return "id不能为负数，请稍后重试。您输入的id为："+id;
    }

}
