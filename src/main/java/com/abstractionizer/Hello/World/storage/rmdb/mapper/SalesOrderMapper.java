package com.abstractionizer.Hello.World.storage.rmdb.mapper;

import com.abstractionizer.Hello.World.model.vo.SalesDetailsVo;
import com.abstractionizer.Hello.World.storage.rmdb.entity.SalesOrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Mapper
@Repository
public interface SalesOrderMapper extends BaseMapper<SalesOrderEntity> {
    int insertEntity(SalesOrderEntity salesOrder);

    IPage<SalesDetailsVo> selectByOrderIdOrProductNameOrCreatedAt(Long customerId, Long orderId, String productName, LocalDateTime from, LocalDateTime to, Page<?> objectPage);
}
