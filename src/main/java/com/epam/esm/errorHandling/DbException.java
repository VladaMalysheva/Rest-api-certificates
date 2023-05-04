package com.epam.esm.errorHandling;

import org.springframework.http.HttpStatus;

public class DbException extends RuntimeException{
    private int errorCode;

    private HttpStatus status;

    public DbException(String message, int errorCode, HttpStatus status) {
        super(message);
        this.errorCode=errorCode;
        this.status=status;
    }

    public DbException(String message, HttpStatus status) {
        super(message);
        this.status=status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


}
