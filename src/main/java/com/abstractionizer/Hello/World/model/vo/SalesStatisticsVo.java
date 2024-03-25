package com.abstractionizer.Hello.World.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class SalesStatisticsVo {
    private Integer numOfSales;
    private BigDecimal totalRevenue;
}
