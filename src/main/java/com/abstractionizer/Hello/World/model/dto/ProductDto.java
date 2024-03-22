package com.abstractionizer.Hello.World.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {
    @Min(value = 1)
    @NotNull
    private Long productId;


    @Min(value = 1)
    @NotNull
    private Integer quantity;
}
