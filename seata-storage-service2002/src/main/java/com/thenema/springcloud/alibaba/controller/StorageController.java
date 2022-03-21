package com.thenema.springcloud.alibaba.controller;

import com.thenema.springcloud.alibaba.domain.CommonResult;
import com.thenema.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaoxiang
 * @data 2022/3/20 14:17
 */
public class StorageController {
    @Autowired
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
