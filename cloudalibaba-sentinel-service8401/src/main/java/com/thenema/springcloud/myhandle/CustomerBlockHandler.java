package com.thenema.springcloud.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.thenema.springcloud.entities.CommonResult;
import com.thenema.springcloud.entities.Payment;

/**
 * @author xiaoxiang
 * @data 2022/3/18 22:30
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(444,"按客户自定义,global handlerException",new Payment(2020L,"serial003"));
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"按客户自定义,global handlerException",new Payment(2020L,"serial003"));
    }
}
