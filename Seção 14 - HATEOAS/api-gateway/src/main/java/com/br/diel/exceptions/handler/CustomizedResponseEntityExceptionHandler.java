package com.br.diel.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.diel.exceptions.ExceptionResponde;
import com.br.diel.exceptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponde> handleAllExceptions(
        Exception ex, WebRequest request) {
        ExceptionResponde exceptionResponde = new ExceptionResponde(
            new Date(),
            ex.getMessage(),
            request.getDescription(false));
        return new ResponseEntity<>(exceptionResponde, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponde> handleNotFoundExceptions(
        Exception ex, WebRequest request) {
        ExceptionResponde exceptionResponde = new ExceptionResponde(
            new Date(),
            ex.getMessage(),
            request.getDescription(false));
        return new ResponseEntity<>(exceptionResponde, HttpStatus.NOT_FOUND);
        }
}
