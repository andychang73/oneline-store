package com.abstractionizer.Hello.World.service;

import com.abstractionizer.Hello.World.storage.rmdb.entity.SalesOrderEntity;

public interface SalesOrderService {
    void insert(SalesOrderEntity salesOrder);
}
