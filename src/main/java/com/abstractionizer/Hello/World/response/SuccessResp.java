package com.abstractionizer.Hello.World.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResp<T> {

    private T data;

    public SuccessResp(){
        this.data = (T)"SUCCESS";
    }

    public SuccessResp(T data){
        this.data = data;
    }
}
