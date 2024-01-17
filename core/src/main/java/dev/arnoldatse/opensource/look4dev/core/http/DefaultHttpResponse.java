package dev.arnoldatse.opensource.look4dev.core.http;

public class DefaultHttpResponse {
    private final int code;
    private final String message;
    public DefaultHttpResponse(HttpCode httpCode, String message){
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
