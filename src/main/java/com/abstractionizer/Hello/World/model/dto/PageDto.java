package com.abstractionizer.Hello.World.model.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PageDto {

    @Min(value = 1)
    protected Long page = 1L;

    @Min(value = 1)
    protected Long size = 1L;

}
