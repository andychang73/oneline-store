package com.abstractionizer.Hello.World.service.impl;

import com.abstractionizer.Hello.World.model.dto.ProductDto;
import com.abstractionizer.Hello.World.model.vo.ProductVo;
import com.abstractionizer.Hello.World.service.SalesOrderDetailService;
import com.abstractionizer.Hello.World.storage.rmdb.entity.SalesOrderDetailEntity;
import com.abstractionizer.Hello.World.storage.rmdb.mapper.SalesOrderDetailMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SalesOrderDetailServiceImpl implements SalesOrderDetailService {

    private final SalesOrderDetailMapper salesOrderDetailMapper;

    public SalesOrderDetailServiceImpl(SalesOrderDetailMapper salesOrderDetailMapper) {
        this.salesOrderDetailMapper = salesOrderDetailMapper;
    }

    @Override
    public List<SalesOrderDetailEntity> getSalesOrderDetails(@NonNull final List<ProductDto> orders,
                                                             @NonNull final Map<Long, ProductVo> productMap) {
        return orders.stream()
                .map(order -> SalesOrderDetailEntity.builder()
                        .productId(order.getProductId())
                        .productName(productMap.get(order.getProductId()).getName())
                        .quantity(order.getQuantity())
                        .price(productMap.get(order.getProductId()).getPrice())
                        .subTotal(BigDecimal.valueOf(order.getQuantity()).multiply(productMap.get(order.getProductId()).getPrice()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void insertBatch(@NonNull final Collection<SalesOrderDetailEntity> salesOrderDetails) {
        if(salesOrderDetails.isEmpty()){
            return;
        }
        salesOrderDetailMapper.insertBatch(salesOrderDetails);
    }

    @Override
    public BigDecimal getTotal(@NonNull final List<SalesOrderDetailEntity> salesOrderDetails) {
        return salesOrderDetails.stream()
                .map(SalesOrderDetailEntity::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
