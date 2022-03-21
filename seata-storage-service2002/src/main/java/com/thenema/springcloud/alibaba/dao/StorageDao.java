package com.thenema.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiaoxiang
 * @data 2022/3/20 13:49
 */
@Mapper
public interface StorageDao {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(@Param("product")Long productId,@Param("count") Integer count);
}
