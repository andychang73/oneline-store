package com.abstractionizer.Hello.World.business.impl;

import com.abstractionizer.Hello.World.business.SalesOrderBusiness;
import com.abstractionizer.Hello.World.exception.BusinessException;
import com.abstractionizer.Hello.World.model.dto.PlaceOrderDto;
import com.abstractionizer.Hello.World.model.vo.ProductVo;
import com.abstractionizer.Hello.World.service.CustomerService;
import com.abstractionizer.Hello.World.service.ProductService;
import com.abstractionizer.Hello.World.service.SalesOrderDetailService;
import com.abstractionizer.Hello.World.service.SalesOrderService;
import com.abstractionizer.Hello.World.storage.rmdb.entity.CustomerEntity;
import com.abstractionizer.Hello.World.storage.rmdb.entity.SalesOrderDetailEntity;
import com.abstractionizer.Hello.World.storage.rmdb.entity.SalesOrderEntity;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static com.abstractionizer.Hello.World.error.Error.DATA_NOT_FOUND;
import static com.abstractionizer.Hello.World.error.Error.INSUFFICIENT_STOCK;

@Service
public class SalesOrderBusinessImpl implements SalesOrderBusiness {

    private final CustomerService customerService;
    private final ProductService productService;
    private final SalesOrderService salesOrderService;
    private final SalesOrderDetailService salesOrderDetailService;

    public SalesOrderBusinessImpl(CustomerService customerService, ProductService productService,
                                  SalesOrderService salesOrderService, SalesOrderDetailService salesOrderDetailService) {
        this.customerService = customerService;
        this.productService = productService;
        this.salesOrderService = salesOrderService;
        this.salesOrderDetailService = salesOrderDetailService;
    }

    @Transactional
    @Override
    public void placeOrder(@NonNull final PlaceOrderDto dto) {

        Map<Long, Integer> productOrderMap = productService.getProductOrderMap(dto.getOrders());

        Map<Long, ProductVo> productMap = productService.getProductMap(productOrderMap.keySet());

        if(productMap.size() != dto.getOrders().size()){
            throw new BusinessException(DATA_NOT_FOUND, "訂單輸入的產品ID不存在");
        }

        if(productService.isInsufficientStock(productOrderMap, productMap)){
            throw new BusinessException(INSUFFICIENT_STOCK);
        }

        productService.updateProductStock(dto.getOrders());

        CustomerEntity customer = customerService.selectByIdOrThrow(dto.getCustomerId());

        SalesOrderEntity salesOrder = SalesOrderEntity.builder()
                .customerId(customer.getId())
                .build();

        salesOrderService.insert(salesOrder);

        List<SalesOrderDetailEntity> salesOrderDetails = salesOrderDetailService.getSalesOrderDetails(salesOrder.getId(), dto.getOrders(), productMap);

        salesOrderDetailService.insertBatch(salesOrderDetails);

    }
}
