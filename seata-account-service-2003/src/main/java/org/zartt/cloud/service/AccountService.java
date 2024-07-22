package org.zartt.cloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author: zartt
 * @description: TODO
 */
public interface AccountService {
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}
