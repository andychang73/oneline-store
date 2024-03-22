package com.abstractionizer.Hello.World.storage.rmdb.mapper;

import com.abstractionizer.Hello.World.model.dto.ProductDto;
import com.abstractionizer.Hello.World.model.vo.ProductVo;
import com.abstractionizer.Hello.World.storage.rmdb.entity.ProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Mapper
@Repository
public interface ProductMapper extends BaseMapper<ProductEntity> {
    IPage<ProductVo> selectAll(Page<ProductVo> objectPage);

    List<ProductVo> getByIds(Collection<Long> ids);

    int updateStockByIds(Collection<ProductDto> products);
}
