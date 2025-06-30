package com.ureca.uble.global.exception;

import org.springframework.http.HttpStatus;

public interface ResultCode {
    HttpStatus getStatus();
    int getCode();
    String getMessage();
}
