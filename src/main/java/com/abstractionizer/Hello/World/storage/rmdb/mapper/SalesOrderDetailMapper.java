package com.abstractionizer.Hello.World.storage.rmdb.mapper;

import com.abstractionizer.Hello.World.storage.rmdb.entity.SalesOrderDetailEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SalesOrderDetailMapper extends BaseMapper<SalesOrderDetailEntity> {
}
