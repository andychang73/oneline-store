package com.abstractionizer.Hello.World.service;

import com.abstractionizer.Hello.World.storage.rmdb.entity.CustomerEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Collection;

public interface CustomerService {

    IPage<CustomerEntity> selectByNames(Collection<String> names, Long page, Long size);
    void create(CustomerEntity entity);

    void update(CustomerEntity entity);

    void remove(CustomerEntity entity);

    void checkPhoneOrThrow(String phone);

    CustomerEntity selectByIdOrThrow(Long id);
}
