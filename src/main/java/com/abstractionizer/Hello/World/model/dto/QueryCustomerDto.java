package com.abstractionizer.Hello.World.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class QueryCustomerDto extends PageDto{
    private List<String> names;
}
