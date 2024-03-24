package com.abstractionizer.Hello.World.service.impl;

import com.abstractionizer.Hello.World.exception.BusinessException;
import com.abstractionizer.Hello.World.model.vo.SalesDetailsVo;
import com.abstractionizer.Hello.World.service.SalesOrderService;
import com.abstractionizer.Hello.World.storage.rmdb.entity.SalesOrderEntity;
import com.abstractionizer.Hello.World.storage.rmdb.mapper.SalesOrderMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    @Override
    public IPage<SalesDetailsVo> getSalesDetails(@NonNull final Long customerId, @Nullable final Long orderId, @Nullable final String productName,
                                                 @Nullable final LocalDateTime from, @Nullable final LocalDateTime to,
                                                 @NonNull final Long page, @NonNull final Long size) {
        return salesOrderMapper.selectByOrderIdOrProductNameOrCreatedAt(
                customerId, orderId, productName, from, to, new Page<>(page, size)
        );
    }

}
