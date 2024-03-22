package com.abstractionizer.Hello.World.service;

import com.abstractionizer.Hello.World.model.dto.ProductDto;
import com.abstractionizer.Hello.World.model.vo.ProductVo;
import com.abstractionizer.Hello.World.storage.rmdb.entity.SalesOrderDetailEntity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface SalesOrderDetailService {
    List<SalesOrderDetailEntity> getSalesOrderDetails(Long salesOrderId, List<ProductDto> orders, Map<Long, ProductVo> productMap);

    void insertBatch(Collection<SalesOrderDetailEntity> salesOrderDetails);
}
