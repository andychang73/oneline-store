package com.abstractionizer.Hello.World.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCustomerDto {

    @NotBlank
    private String phone;

    @NotBlank
    private String name;

    @NotBlank
    private String address;
}
