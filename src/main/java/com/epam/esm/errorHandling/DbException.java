package com.epam.esm.errorHandling;

public class DbException extends RuntimeException{
    private int errorCode;
    private int status;
    public DbException(String message, int errorCode, int status) {
        super(message);
        this.errorCode=errorCode;
        this.status=status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
