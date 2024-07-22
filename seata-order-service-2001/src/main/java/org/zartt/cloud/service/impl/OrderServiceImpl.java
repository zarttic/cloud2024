package org.zartt.cloud.service.impl;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zartt.cloud.apis.AccountFeignApi;
import org.zartt.cloud.apis.StorageFeignApi;
import org.zartt.cloud.entities.Order;
import org.zartt.cloud.mapper.OrderMapper;
import org.zartt.cloud.service.OrderService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: zartt
 * @description: TODO
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;
    //库存
    @Resource
    StorageFeignApi storageFeignApi;
    //账户
    @Resource
    AccountFeignApi accountFeignApi;
    /**
     * 创建订单
     *
     * @param order
     */
    @Override
    @GlobalTransactional(name = "create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        //检查XID
        String xid = RootContext.getXID();
        log.info("__订单开始__" + xid);
        log.info("------->xid={},order={}",xid,order.getId());
        //设置订单为初始状态
        order.setStatus(0);
        //插入实体
        int result = orderMapper.insert(order);
        Order orderFromDb = null;
        if(result > 0){
            orderFromDb = orderMapper.selectOne(order);

            log.info("新建订单成功"+orderFromDb);
            log.info("__调用storage微服务，扣减库存开始__");
            storageFeignApi.decrease(orderFromDb.getProductId(),orderFromDb.getCount());
            log.info("__调用storage微服务，扣减库存结束__");

            log.info("__调用account微服务，扣减账户余额开始__");
            accountFeignApi.decrease(orderFromDb.getUserId(),orderFromDb.getMoney());
            log.info("__调用account微服务，扣减账户余额结束__");

            //订单成功提交，修改订单状态
            orderFromDb.setStatus(1);

            int updResult = orderMapper.updateByPrimaryKey(orderFromDb);

        }else{
            log.info("订单创建失败");
        }
        log.info("__订单结束__" + xid);

    }
}
