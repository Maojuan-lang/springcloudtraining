package com.thenema.springcloud.alibaba.service;

import com.thenema.springcloud.alibaba.domain.Order;

/**
 * @author xiaoxiang
 * @data 2022/3/20 11:08
 */
public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
