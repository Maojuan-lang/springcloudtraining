package com.thenema.springcloud.alibaba.controller;

import com.thenema.springcloud.alibaba.domain.CommonResult;
import com.thenema.springcloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author xiaoxiang
 * @data 2022/3/20 15:15
 */
@RestController
public class AccountController {
    @Resource
    AccountService accountService;

    @RequestMapping("/account/decrese")
    public CommonResult decrease(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200,"扣减账户余额成功");
    }
}
