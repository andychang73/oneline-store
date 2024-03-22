package com.abstractionizer.Hello.World.service.impl;

import com.abstractionizer.Hello.World.exception.BusinessException;
import com.abstractionizer.Hello.World.service.CustomerService;
import com.abstractionizer.Hello.World.storage.rmdb.entity.CustomerEntity;
import com.abstractionizer.Hello.World.storage.rmdb.mapper.CustomerMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static com.abstractionizer.Hello.World.error.Error.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public IPage<CustomerEntity> selectByNames(@Nullable final Collection<String> names, @NonNull final Long page, @NonNull final Long size) {
        return customerMapper.selectByNames(names, new Page<>(page,size));
    }

    @Override
    public void create(@NonNull final CustomerEntity entity) {
        if(customerMapper.insert(entity) != 1){
            throw new BusinessException(CREATE_DATA_FAILED);
        }
    }

    @Override
    public void update(CustomerEntity entity) {
        updateCustomer(entity);
    }

    @Override
    public void remove(CustomerEntity entity) {
        updateCustomer(entity);
    }

    @Override
    public void checkPhoneOrThrow(@NonNull final String phone) {
        if(customerMapper.selectByPhone(phone) != null){
            throw new BusinessException(DATA_IS_CREATED);
        }
    }

    @Override
    public CustomerEntity selectByIdOrThrow(@NonNull final Long id) {
        return Optional.ofNullable(customerMapper.selectById(id))
                .orElseThrow(() -> new BusinessException(DATA_NOT_FOUND));
    }

    private void updateCustomer(CustomerEntity entity){
        if(customerMapper.updateById(entity) != 1){
            throw new BusinessException(UPDATE_DATA_FAILED);
        }
    }
}
