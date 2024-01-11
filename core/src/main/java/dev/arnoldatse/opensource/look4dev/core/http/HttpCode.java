package dev.arnoldatse.opensource.look4dev.core.http;

public enum HttpCode {
    OK(200),
    CREATED(201),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    PAYMENT_REQUIRED(402),
    FORBIDDEN(403),
    NOT_FOUND(404),
    NOT_ACCEPTABLE(406),
    INTERNAL_SERVER_ERROR(500);


    private final int value;
    HttpCode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
