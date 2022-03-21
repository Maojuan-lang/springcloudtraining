package com.thenema.springcloud.alibaba.service;

/**
 * @author xiaoxiang
 * @data 2022/3/20 14:06
 */
public interface StorageService {
    void decrease(Long productId,Integer count);
}
