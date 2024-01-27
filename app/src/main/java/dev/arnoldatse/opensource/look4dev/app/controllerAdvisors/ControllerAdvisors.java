package dev.arnoldatse.opensource.look4dev.app.controllerAdvisors;

import dev.arnoldatse.opensource.look4dev.core.email.FailedToSendEmailException;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.http.HttpCode;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.FileExtensionNotSupportedException;
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
    @ExceptionHandler(FailedToStoreFileException.class)
    public ResponseEntity<DefaultHttpResponse> failedToStoreException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpResponse(HttpCode.INTERNAL_SERVER_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(FileExtensionNotSupportedException.class)
    public ResponseEntity<DefaultHttpResponse> fileExtensionNotSupported(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpResponse(HttpCode.FORBIDDEN, ex.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ResponseBody
    @ExceptionHandler(FailedToSendEmailException.class)
    public ResponseEntity<DefaultHttpResponse> failedToSendEmailException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new DefaultHttpResponse(HttpCode.INTERNAL_SERVER_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
