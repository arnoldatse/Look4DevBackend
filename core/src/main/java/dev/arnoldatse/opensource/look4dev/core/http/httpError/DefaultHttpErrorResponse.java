package dev.arnoldatse.opensource.look4dev.core.http.httpError;

import dev.arnoldatse.opensource.look4dev.core.http.HttpCode;

public class DefaultHttpErrorResponse {
    private final int code;
    private final String message;
    public DefaultHttpErrorResponse(HttpCode httpCode, String message){
        code = httpCode.getValue();
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
