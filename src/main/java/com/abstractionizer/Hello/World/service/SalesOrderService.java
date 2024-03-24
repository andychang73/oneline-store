package com.abstractionizer.Hello.World.service;

import com.abstractionizer.Hello.World.model.vo.SalesDetailsVo;
import com.abstractionizer.Hello.World.storage.rmdb.entity.SalesOrderEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.time.LocalDateTime;

public interface SalesOrderService {
    void insert(SalesOrderEntity salesOrder);

    IPage<SalesDetailsVo> getSalesDetails(Long customerId, Long orderId, String productName,
                                          LocalDateTime from, LocalDateTime to,
                                          Long page, Long size);
}
