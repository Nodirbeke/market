package com.example.market.enums;

public enum StatusCode {

    SUCCESS(200),
    UNKNOWN(500),
    NOT_FOUND(404),
    BAD_REQUEST(400);

    private final int status;


    StatusCode(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}

