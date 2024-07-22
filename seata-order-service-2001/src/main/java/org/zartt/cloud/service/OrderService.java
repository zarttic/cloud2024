package org.zartt.cloud.service;

import org.zartt.cloud.entities.Order;

/**
 * @author: zartt
 * @description: TODO
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);

}
