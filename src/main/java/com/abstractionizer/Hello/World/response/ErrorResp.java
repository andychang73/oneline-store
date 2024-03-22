package com.abstractionizer.Hello.World.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResp {
    private String code;
    private String message;
    private Object details;
}
