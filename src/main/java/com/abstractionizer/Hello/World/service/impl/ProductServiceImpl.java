package com.abstractionizer.Hello.World.service.impl;

import com.abstractionizer.Hello.World.model.vo.ProductVo;
import com.abstractionizer.Hello.World.service.ProductService;
import com.abstractionizer.Hello.World.storage.rmdb.mapper.ProductMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public IPage<ProductVo> getProducts(@NonNull final Long page, @NonNull final Long size) {
        return productMapper.selectAll(new Page<>(page, size));
    }
}
