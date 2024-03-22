package com.abstractionizer.Hello.World.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error implements BaseError{

    DATA_NOT_FOUND(400, "002001", "資料不存在"),
    DATA_IS_CREATED(400, "002002", "資料已存在"),
    CREATE_DATA_FAILED(400, "002003", "建立失敗"),
    UPDATE_DATA_FAILED(400, "002004", "更新失敗"),

    ;

    private final int httpStatus;
    private final String code;
    private final String message;

    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
