package org.zartt.cloud.service.impl;

import cn.hutool.log.Log;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zartt.cloud.mapper.StorageMapper;
import org.zartt.cloud.service.StorageService;

/**
 * @author: zartt
 * @description: TODO
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    StorageMapper storageMapper;
    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("开始扣减{}库存，扣减{}",productId,count);
        storageMapper.decrease(productId,count);
        log.info("扣减:{}库存结束，扣减{}",productId,count);

    }
}
