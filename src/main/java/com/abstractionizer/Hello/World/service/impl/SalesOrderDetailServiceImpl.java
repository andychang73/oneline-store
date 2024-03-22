package com.abstractionizer.Hello.World.service.impl;

import com.abstractionizer.Hello.World.service.SalesOrderDetailService;
import com.abstractionizer.Hello.World.storage.rmdb.mapper.SalesOrderDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class SalesOrderDetailServiceImpl implements SalesOrderDetailService {

    private final SalesOrderDetailMapper salesOrderDetailMapper;

    public SalesOrderDetailServiceImpl(SalesOrderDetailMapper salesOrderDetailMapper) {
        this.salesOrderDetailMapper = salesOrderDetailMapper;
    }
}
