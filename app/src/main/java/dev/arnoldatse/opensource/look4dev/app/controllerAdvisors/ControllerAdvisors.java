package dev.arnoldatse.opensource.look4dev.app.controllerAdvisors;

import dev.arnoldatse.opensource.look4dev.core.fileStorage.FailToStoreException;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.http.HttpCode;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.RepositoryException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("dev.arnoldatse.opensource.look4dev.app")
public class ControllerAdvisors {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultHttpResponse> defaultException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpResponse(HttpCode.UNKNOWN_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DefaultHttpResponse> notFoundException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpResponse(HttpCode.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(RepositoryException.class)
    public ResponseEntity<DefaultHttpResponse> repositoryException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpResponse(HttpCode.INTERNAL_SERVER_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(FailToStoreException.class)
    public ResponseEntity<DefaultHttpResponse> failToStoreException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpResponse(HttpCode.INTERNAL_SERVER_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}