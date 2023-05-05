package com.epam.esm.errorHandling;

public class ErrorResponse {

    private int status;
    private String message;
    private int errorCode;
    private long timeStamp;

    public ErrorResponse(int status, String message, int errorCode, long timeStamp) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.timeStamp = timeStamp;
    }

    public ErrorResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
