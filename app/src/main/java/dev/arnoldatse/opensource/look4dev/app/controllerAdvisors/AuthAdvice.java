package dev.arnoldatse.opensource.look4dev.app.controllerAdvisors;

import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.http.HttpCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("dev.arnoldatse.opensource.look4dev.app")
public class AuthAdvice {
    @ResponseBody
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<DefaultHttpResponse> BadCredentialHandleException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpResponse(HttpCode.UNAUTHORIZED, ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ResponseBody
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<DefaultHttpResponse> UsernameNotFoundHandleException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpResponse(HttpCode.UNAUTHORIZED, ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
