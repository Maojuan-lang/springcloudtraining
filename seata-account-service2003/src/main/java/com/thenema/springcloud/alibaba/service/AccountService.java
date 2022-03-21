package com.thenema.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author xiaoxiang
 * @data 2022/3/20 15:09
 */
public interface AccountService {
    /**
     * 账户余额减少
     * @param userId
     * @param money
     */
    void decrease(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money);
}
