package com.abstractionizer.Hello.World.business;

import com.abstractionizer.Hello.World.model.vo.PageVo;
import com.abstractionizer.Hello.World.model.vo.ProductVo;

public interface ProductBusiness {

    PageVo<ProductVo> getProducts(Long page, Long size);
}
