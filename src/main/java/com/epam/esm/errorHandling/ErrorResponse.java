package com.epam.esm.errorHandling;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private int errorCode;
    private long timeStamp;

    public ErrorResponse(HttpStatus status, String message, int errorCode, long timeStamp) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.timeStamp = timeStamp;
    }

    public ErrorResponse() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", errorCode=" + errorCode +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
