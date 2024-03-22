package com.abstractionizer.Hello.World.controller;

import com.abstractionizer.Hello.World.business.ProductBusiness;
import com.abstractionizer.Hello.World.model.dto.PageDto;
import com.abstractionizer.Hello.World.model.vo.PageVo;
import com.abstractionizer.Hello.World.model.vo.ProductVo;
import com.abstractionizer.Hello.World.response.SuccessResp;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductBusiness productBusiness;

    public ProductController(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }


    @GetMapping
    public SuccessResp<PageVo<ProductVo>> getProducts(@Valid PageDto dto){
        return new SuccessResp<>(productBusiness.getProducts(dto.getPage(), dto.getSize()));
    }
}
