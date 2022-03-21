package com.thenema.springcloud.alibaba.controller;

import com.thenema.springcloud.alibaba.domain.CommonResult;
import com.thenema.springcloud.alibaba.domain.Order;
import com.thenema.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaoxiang
 * @data 2022/3/20 12:09
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"create order successfully");
    }
}
