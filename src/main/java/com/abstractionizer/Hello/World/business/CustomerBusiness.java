package com.abstractionizer.Hello.World.business;

import com.abstractionizer.Hello.World.model.dto.CreateCustomerDto;
import com.abstractionizer.Hello.World.model.dto.QueryCustomerDto;
import com.abstractionizer.Hello.World.model.dto.UpdateCustomerDto;
import com.abstractionizer.Hello.World.model.vo.PageVo;
import com.abstractionizer.Hello.World.storage.rmdb.entity.CustomerEntity;

public interface CustomerBusiness {

    PageVo<CustomerEntity> getCustomers(QueryCustomerDto dto);

    void createCustomer(CreateCustomerDto dto);

    void updateCustomer(Long id, UpdateCustomerDto dto);
}
