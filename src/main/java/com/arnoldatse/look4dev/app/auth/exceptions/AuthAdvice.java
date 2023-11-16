package com.arnoldatse.look4dev.app.auth.exceptions;

import com.arnoldatse.look4dev.core.http.DefaultHttpError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.arnoldatse.look4dev.app.auth.rest")
public class AuthAdvice {
    @ResponseBody
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<DefaultHttpError> handleException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpError(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
