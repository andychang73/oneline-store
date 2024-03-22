package com.abstractionizer.Hello.World.error;

public interface BaseError {

    int getHttpStatus();

    String getCode();

    String message();
}
