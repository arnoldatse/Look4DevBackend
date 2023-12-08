package dev.arnoldatse.opensource.look4dev.app.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.arnoldatse.look4dev.app")
public class NotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<NotFoundException> handleException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new NotFoundException(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
