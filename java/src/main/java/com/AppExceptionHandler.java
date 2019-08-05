package com;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {CustomException.class})
  public ResponseEntity<Object> handleAnyException(CustomException ex, String Message) {
    return new ResponseEntity<>(
    Message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
    );
  }
}
