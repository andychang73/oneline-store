package com.abstractionizer.Hello.World.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PlaceOrderDto {

    @Min(value = 1)
    @NotNull
    private Long customerId;

    @Valid
    private List<ProductDto> orders;
}
