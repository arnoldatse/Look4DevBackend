package dev.arnoldatse.opensource.look4dev.app.controllerAdvisors;

import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.http.HttpCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("dev.arnoldatse.opensource.look4dev.app")
public class DefaultExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultHttpResponse> handleException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpResponse(HttpCode.UNKNOWN_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
