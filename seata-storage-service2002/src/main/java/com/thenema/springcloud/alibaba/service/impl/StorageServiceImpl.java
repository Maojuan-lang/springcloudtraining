package com.thenema.springcloud.alibaba.service.impl;

import com.thenema.springcloud.alibaba.dao.StorageDao;
import com.thenema.springcloud.alibaba.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;


/**
 * @author xiaoxiang
 * @data 2022/3/20 14:06
 */
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER =  LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("---->storage-service 扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("---->storage-service 扣减库存结束");
    }
}
