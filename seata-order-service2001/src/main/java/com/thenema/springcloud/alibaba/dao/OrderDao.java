package com.thenema.springcloud.alibaba.dao;

import com.thenema.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiaoxiang
 * @data 2022/3/20 10:44
 */
@Mapper
public interface OrderDao {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态
      * @param userId
     * @param states
     */
    void update(@Param("userId")Long userId,@Param("status")Integer states);
}
