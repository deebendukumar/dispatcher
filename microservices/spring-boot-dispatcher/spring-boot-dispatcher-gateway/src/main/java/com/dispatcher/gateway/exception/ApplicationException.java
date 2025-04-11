package com.dispatcher.gateway.exception;

import lombok.Data;

@Data
public class ApplicationException extends RuntimeException {

    private Integer status;
    private String message;

    public ApplicationException(Integer status, String detail) {
        super(detail);
        this.status = status;
        this.message = detail;
    }
}
