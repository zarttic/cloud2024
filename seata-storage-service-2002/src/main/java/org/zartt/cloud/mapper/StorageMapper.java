package org.zartt.cloud.mapper;

import org.apache.ibatis.annotations.Param;
import org.zartt.cloud.entities.Storage;
import tk.mybatis.mapper.common.Mapper;

public interface StorageMapper extends Mapper<Storage> {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}