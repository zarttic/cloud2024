package org.zartt.cloud.service;

/**
 * @author: zartt
 * @description: TODO
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
