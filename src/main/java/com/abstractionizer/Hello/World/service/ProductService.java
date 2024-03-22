package com.abstractionizer.Hello.World.service;

import com.abstractionizer.Hello.World.model.vo.ProductVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface ProductService {
    IPage<ProductVo> getProducts(Long page, Long size);
}
