package com.abstractionizer.Hello.World.storage.rmdb.entity;

import com.abstractionizer.Hello.World.enumeration.CustomerStatus;
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
@TableName("customer")
public class CustomerEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String phone;

    private String name;

    private String address;

    private CustomerStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
