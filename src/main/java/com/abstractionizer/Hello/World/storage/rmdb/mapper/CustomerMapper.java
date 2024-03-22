package com.abstractionizer.Hello.World.storage.rmdb.mapper;

import com.abstractionizer.Hello.World.storage.rmdb.entity.CustomerEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface CustomerMapper extends BaseMapper<CustomerEntity> {
    IPage<CustomerEntity> selectByNames(Collection<String> names, Page<?> page);

    CustomerEntity selectByPhone(String phone);
}
