package com.maxi.apiProducto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    
    @ExceptionHandler(EntityFindByIdNotFoundException.class)
    public ResponseEntity<StandardError> entityFindByIdNotFoundException(EntityFindByIdNotFoundException e){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EntityDuplicatedNameCreationException.class)
    public ResponseEntity<StandardError> entityDuplicatedNameCreationException(EntityDuplicatedNameCreationException e){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
}
