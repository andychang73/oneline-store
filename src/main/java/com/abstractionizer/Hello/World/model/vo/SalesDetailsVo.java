package com.abstractionizer.Hello.World.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class SalesDetailsVo {
    private Long orderId;
    private BigDecimal total;
    private LocalDateTime date;
    private List<ProductDetailsVo> productDetails;
}
