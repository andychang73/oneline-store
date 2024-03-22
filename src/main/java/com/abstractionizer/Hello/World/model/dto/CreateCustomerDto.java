package com.abstractionizer.Hello.World.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCustomerDto {

    @NotBlank
    private String phone;

    @NotBlank
    private String name;

    @NotBlank
    private String address;
}
