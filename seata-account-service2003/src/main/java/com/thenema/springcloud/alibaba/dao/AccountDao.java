package com.thenema.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author xiaoxiang
 * @data 2022/3/20 14:54
 */
@Mapper
public interface AccountDao {
    /**
     * 扣减账户余额
     * @param userId
     * @param money
     */
    void decrease(@Param("userId")Long userId, @Param("money")BigDecimal money);
}
