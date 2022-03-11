package com.jellyfish.moviespringapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex, WebRequest webRequest) {
        String errorMessageDescription = ex.getLocalizedMessage();
        if (errorMessageDescription == null)
            errorMessageDescription = ex.toString();
        return new ResponseEntity<>(errorMessageDescription, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<Object> handleMovieNotFoundException(MovieNotFoundException ex, WebRequest webRequest) {
        String errorMessageDescription = ex.getLocalizedMessage();
        if (errorMessageDescription == null)
            errorMessageDescription = ex.toString();
        return new ResponseEntity<>(errorMessageDescription, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
