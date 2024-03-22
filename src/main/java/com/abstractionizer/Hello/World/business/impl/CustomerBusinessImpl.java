package com.abstractionizer.Hello.World.business.impl;

import com.abstractionizer.Hello.World.business.CustomerBusiness;
import com.abstractionizer.Hello.World.model.dto.CreateCustomerDto;
import com.abstractionizer.Hello.World.model.dto.QueryCustomerDto;
import com.abstractionizer.Hello.World.model.dto.UpdateCustomerDto;
import com.abstractionizer.Hello.World.model.vo.PageVo;
import com.abstractionizer.Hello.World.service.CustomerService;
import com.abstractionizer.Hello.World.storage.rmdb.entity.CustomerEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerBusinessImpl implements CustomerBusiness {

    private final CustomerService customerService;

    public CustomerBusinessImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public PageVo<CustomerEntity> getCustomers(@NonNull final QueryCustomerDto dto) {

        IPage<CustomerEntity> customers = customerService.selectByNames(dto.getNames(), dto.getPage(), dto.getSize());

        return new PageVo<>(customers.getTotal(), customers.getSize(),
                customers.getCurrent(), customers.getPages(), customers.getRecords());
    }

    @Transactional
    @Override
    public void createCustomer(@NonNull final CreateCustomerDto dto) {

        customerService.checkPhoneOrThrow(dto.getPhone());

        CustomerEntity customerEntity = CustomerEntity.builder()
                .phone(dto.getPhone())
                .name(dto.getName())
                .address(dto.getAddress())
                .build();

        customerService.create(customerEntity);
    }

    @Transactional
    @Override
    public void updateCustomer(@NonNull final Long id, @NonNull final UpdateCustomerDto dto) {

        CustomerEntity customerEntity = customerService.selectByIdOrThrow(id);

        if(!customerEntity.getPhone().equals(dto.getPhone())){
            customerService.checkPhoneOrThrow(dto.getPhone());
        }

        customerEntity.setPhone(dto.getPhone());
        customerEntity.setName(dto.getName());
        customerEntity.setAddress(dto.getAddress());

        customerService.update(customerEntity);
    }
}
