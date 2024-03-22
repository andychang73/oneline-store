package com.abstractionizer.Hello.World.business.impl;

import com.abstractionizer.Hello.World.business.ProductBusiness;
import com.abstractionizer.Hello.World.model.vo.PageVo;
import com.abstractionizer.Hello.World.model.vo.ProductVo;
import com.abstractionizer.Hello.World.service.ProductService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ProductBusinessImpl implements ProductBusiness {

    private final ProductService productService;

    public ProductBusinessImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public PageVo<ProductVo> getProducts(@NonNull final Long page, @NonNull final Long size) {

        IPage<ProductVo> products = productService.getProducts(page, size);

        return new PageVo<>(products.getTotal(), products.getSize(),
                products.getCurrent(), products.getPages(), products.getRecords());
    }
}
