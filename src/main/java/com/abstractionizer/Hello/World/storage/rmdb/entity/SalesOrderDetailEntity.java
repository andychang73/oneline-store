package com.abstractionizer.Hello.World.storage.rmdb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sales_order_detail")
public class SalesOrderDetailEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long salesOrderId;

    private Long productId;

    private Integer quantity;

    private BigDecimal subTotal;
}
