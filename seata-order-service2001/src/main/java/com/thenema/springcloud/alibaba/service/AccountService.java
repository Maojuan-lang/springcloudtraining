package com.thenema.springcloud.alibaba.service;

import com.thenema.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author xiaoxiang
 * @data 2022/3/20 11:14
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping
    CommonResult decrease(@RequestParam("accountId")Long id, @RequestParam("money")BigDecimal money);
}
