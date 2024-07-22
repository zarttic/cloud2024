package org.zartt.cloud.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zartt.cloud.mapper.AccountMapper;
import org.zartt.cloud.service.AccountService;

import java.util.concurrent.TimeUnit;

/**
 * @author: zartt
 * @description: TODO
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    /**
     * @param userId
     * @param money
     */
    @Override
    public void decrease(Long userId, Long money) {
        log.info("开始扣减用户{}的{}钱，",userId,money);
        accountMapper.decrease(userId,money);
        myTimeOut();
        log.info("成功扣减用户{}的{}钱，",userId,money);

    }
    /**
     * 模拟超时异常，全局事务回滚
     */
    private static void myTimeOut()
    {
        try { TimeUnit.SECONDS.sleep(65); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
