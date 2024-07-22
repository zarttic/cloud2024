package org.zartt.cloud.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zartt.cloud.entities.Order;
import org.zartt.cloud.resp.ResultData;
import org.zartt.cloud.service.OrderService;

/**
 * @author: zartt
 * @description: TODO
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public ResultData create(Order order)
    {
        orderService.create(order);
        return ResultData.success(order);
    }
}