package com.abstractionizer.Hello.World.storage.rmdb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sales_order")
public class SalesOrderEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long customerId;

    private LocalDateTime createdAt;
}
