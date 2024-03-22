package com.abstractionizer.Hello.World.business;

import com.abstractionizer.Hello.World.model.dto.PlaceOrderDto;

public interface SalesOrderBusiness {

    void placeOrder(PlaceOrderDto dto);
}
