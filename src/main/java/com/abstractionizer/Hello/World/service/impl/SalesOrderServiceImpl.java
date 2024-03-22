package com.abstractionizer.Hello.World.service.impl;

import com.abstractionizer.Hello.World.exception.BusinessException;
import com.abstractionizer.Hello.World.service.SalesOrderService;
import com.abstractionizer.Hello.World.storage.rmdb.entity.SalesOrderEntity;
import com.abstractionizer.Hello.World.storage.rmdb.mapper.SalesOrderMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import static com.abstractionizer.Hello.World.error.Error.CREATE_DATA_FAILED;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    private final SalesOrderMapper salesOrderMapper;

    public SalesOrderServiceImpl(SalesOrderMapper salesOrderMapper) {
        this.salesOrderMapper = salesOrderMapper;
    }

    @Override
    public void insert(@NonNull final SalesOrderEntity salesOrder) {
        if(salesOrderMapper.insertEntity(salesOrder) != 1){
            throw new BusinessException(CREATE_DATA_FAILED);
        }
    }
}
