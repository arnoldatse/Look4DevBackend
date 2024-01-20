package dev.arnoldatse.opensource.look4dev.app.controllerAdvisors;

import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.http.HttpCode;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("dev.arnoldatse.opensource.look4dev.app")
public class NotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DefaultHttpResponse> handleException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpResponse(HttpCode.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
