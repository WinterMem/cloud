package com.pch.common.exception;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pch.common.response.CommonResult;
import com.pch.common.response.ResultCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultGlobalExceptionHandlerAdvice {


    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public CommonResult<String> serviceException(MethodArgumentNotValidException ex) {
        log.error("service exception:{}", ex.getMessage());
        return CommonResult.failed(ResultCode.VALIDATE_FAILED.getCode(), Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult<Boolean> exception(Exception ex) {
        return CommonResult.failed(ResultCode.FAILED.getCode(), ex.getMessage());
    }
}
