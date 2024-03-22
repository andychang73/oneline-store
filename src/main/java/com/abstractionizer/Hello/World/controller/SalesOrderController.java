package com.abstractionizer.Hello.World.controller;

import com.abstractionizer.Hello.World.business.SalesOrderBusiness;
import com.abstractionizer.Hello.World.model.dto.PlaceOrderDto;
import com.abstractionizer.Hello.World.response.SuccessResp;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/salesOrder")
public class SalesOrderController {

    private final SalesOrderBusiness salesOrderBusiness;

    public SalesOrderController(SalesOrderBusiness salesOrderBusiness) {
        this.salesOrderBusiness = salesOrderBusiness;
    }

    @PostMapping
    public SuccessResp<Void> placeOrder(@RequestBody @Valid PlaceOrderDto dto){
        salesOrderBusiness.placeOrder(dto);
        return new SuccessResp<>();
    }
}
