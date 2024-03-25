package com.abstractionizer.Hello.World.service;

import com.abstractionizer.Hello.World.model.vo.SalesDetailsVo;
import com.abstractionizer.Hello.World.model.vo.SalesStatisticsVo;
import com.abstractionizer.Hello.World.storage.rmdb.entity.SalesOrderEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.time.LocalDateTime;
import java.util.List;

public interface SalesOrderService {
    void insert(SalesOrderEntity salesOrder);

    List<Long> getSalesDetailOrderIds(Long customerId, Long orderId, String productName,
                                      LocalDateTime from, LocalDateTime to);

    IPage<SalesDetailsVo> getSalesDetails(List<Long> orderId, Long page, Long size);

    SalesStatisticsVo getSalesStatistics(LocalDateTime from, LocalDateTime to);
}
