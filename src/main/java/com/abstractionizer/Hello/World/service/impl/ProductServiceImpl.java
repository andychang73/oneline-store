package com.abstractionizer.Hello.World.service.impl;

import com.abstractionizer.Hello.World.exception.BusinessException;
import com.abstractionizer.Hello.World.model.dto.ProductDto;
import com.abstractionizer.Hello.World.model.vo.ProductVo;
import com.abstractionizer.Hello.World.service.ProductService;
import com.abstractionizer.Hello.World.storage.rmdb.mapper.ProductMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.abstractionizer.Hello.World.error.Error.*;

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

    @Override
    public List<ProductVo> selectByIdsForUpdate(@NonNull final Collection<Long> productId) {
        return Optional.ofNullable(productMapper.getByIds(productId)).orElseThrow(() -> new BusinessException(DATA_NOT_FOUND));
    }

    @Override
    public void checkStockOrThrow(@NonNull final Integer quantity, @NonNull final Integer stock) {
        if(stock < quantity){
            throw new BusinessException(INSUFFICIENT_STOCK);
        }
    }

    @Override
    public Map<Long, Integer> getProductOrderMap(@NonNull final List<ProductDto> orders) {
        return orders.stream().collect(Collectors.toMap(ProductDto::getProductId, ProductDto::getQuantity));
    }

    @Override
    public Map<Long, ProductVo> getProductMap(@NonNull final Set<Long> productIds) {
        return selectByIdsForUpdate(productIds).stream().collect(Collectors.toMap(ProductVo::getId, v -> v));
    }

    @Override
    public boolean isInsufficientStock(@NonNull final Map<Long, Integer> productOrderMap, @NonNull final Map<Long, ProductVo> productMap) {
        return productOrderMap.entrySet().stream().anyMatch(order -> order.getValue() > productMap.get(order.getKey()).getStock());
    }

    @Override
    public void updateProductStock(@NonNull final Collection<ProductDto> products) {
        if(products.isEmpty()){
            return;
        }
        productMapper.updateStockByIds(products);
    }
}
