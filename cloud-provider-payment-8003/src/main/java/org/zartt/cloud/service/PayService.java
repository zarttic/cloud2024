package org.zartt.cloud.service;

import org.zartt.cloud.entity.Pay;

import java.util.List;

/**
 * @author: zartt
 * @description: TODO
 */
public interface PayService {
    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);

    public Pay   getById(Integer id);
    public List<Pay> getAll();
}
