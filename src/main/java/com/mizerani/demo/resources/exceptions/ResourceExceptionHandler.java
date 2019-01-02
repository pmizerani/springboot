package com.mizerani.demo.resources.exceptions;

import com.mizerani.demo.services.exceptions.DataIntegrityException;
import com.mizerani.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

     @ExceptionHandler(ObjectNotFoundException.class)
     public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
          StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
     }

     @ExceptionHandler(DataIntegrityException.class)
     public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
          StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
     }

     @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<StandardError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {

          ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis());

          e.getBindingResult().getFieldErrors().forEach(error -> {
               err.addError(error.getField(), error.getDefaultMessage());
          });

          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
     }

}
