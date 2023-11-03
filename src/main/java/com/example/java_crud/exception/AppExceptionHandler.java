package com.example.java_crud.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.NoSuchElementException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponse> handleSqlIntegrityException(SQLException exception){
        ErrorResponse response = new ErrorResponse(
                        HttpStatus.BAD_REQUEST,
                "Невозможно создать объект: " + exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException exception){
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND,
                "Не удалось найти объект: " + exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
