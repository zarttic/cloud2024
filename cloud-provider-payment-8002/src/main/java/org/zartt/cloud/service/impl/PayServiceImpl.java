package org.zartt.cloud.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.zartt.cloud.entity.Pay;
import org.zartt.cloud.mapper.PayMapper;
import org.zartt.cloud.service.PayService;

import java.util.List;

/**
 * @author: zartt
 * @description: TODO
 */
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;
    /**
     * @param pay
     * @return
     */
    @Override
    public int add(Pay pay) {
        //null 会使用数据库的默认值代替
        return payMapper.insertSelective(pay);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param pay
     * @return
     */
    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    /**
     * @return 所有数据
     */
    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
