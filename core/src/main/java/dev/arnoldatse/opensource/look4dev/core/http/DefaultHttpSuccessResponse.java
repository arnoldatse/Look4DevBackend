package dev.arnoldatse.opensource.look4dev.core.http;

public class DefaultHttpSuccessResponse {
    private final int code;
    private final String message;
    public DefaultHttpSuccessResponse(HttpCode httpCode, String message){
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
