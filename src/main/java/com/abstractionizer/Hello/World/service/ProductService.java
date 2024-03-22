package com.abstractionizer.Hello.World.service;

import com.abstractionizer.Hello.World.model.dto.ProductDto;
import com.abstractionizer.Hello.World.model.vo.ProductVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {
    IPage<ProductVo> getProducts(Long page, Long size);

    List<ProductVo> selectByIdsForUpdate(Collection<Long> productId);

    void checkStockOrThrow(Integer quantity, Integer stock);

    Map<Long, Integer> getProductOrderMap(List<ProductDto> orders);

    Map<Long, ProductVo> getProductMap(Set<Long> productIds);

    boolean isInsufficientStock(Map<Long, Integer> productOrderMap, Map<Long, ProductVo> productMap);

    void updateProductStock(Collection<ProductDto> products);
}
