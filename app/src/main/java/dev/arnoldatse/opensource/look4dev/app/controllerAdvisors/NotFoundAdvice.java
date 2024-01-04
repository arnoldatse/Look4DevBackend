package dev.arnoldatse.opensource.look4dev.app.controllerAdvisors;

import dev.arnoldatse.opensource.look4dev.core.http.HttpCode;
import dev.arnoldatse.opensource.look4dev.core.http.httpError.DefaultHttpErrorResponse;
import dev.arnoldatse.opensource.look4dev.core.http.httpError.exceptions.NotFoundHttpErrorException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("dev.arnoldatse.opensource.look4dev.app")
public class NotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(NotFoundHttpErrorException.class)
    public ResponseEntity<DefaultHttpErrorResponse> handleException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpErrorResponse(HttpCode.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
