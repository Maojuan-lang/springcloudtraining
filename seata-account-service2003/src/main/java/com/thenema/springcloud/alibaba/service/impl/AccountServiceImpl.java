package com.thenema.springcloud.alibaba.service.impl;

import com.thenema.springcloud.alibaba.dao.AccountDao;
import com.thenema.springcloud.alibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author xiaoxiang
 * @data 2022/3/20 15:13
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("---->account-service 扣减账户余额开始");
        accountDao.decrease(userId,money);
        LOGGER.info("---->account-service 扣减账户余额结束");
    }
}
