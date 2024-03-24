package com.abstractionizer.Hello.World.business;

import com.abstractionizer.Hello.World.model.dto.PlaceOrderDto;
import com.abstractionizer.Hello.World.model.dto.SalesDetailsDto;
import com.abstractionizer.Hello.World.model.vo.PageVo;
import com.abstractionizer.Hello.World.model.vo.SalesDetailsVo;

public interface SalesOrderBusiness {

    void placeOrder(PlaceOrderDto dto);

    PageVo<SalesDetailsVo> getSalesDetails(SalesDetailsDto dto);
}
