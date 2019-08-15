package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid "  )
public class InvalidEntityException extends RuntimeException {
  public InvalidEntityException(Class clazz) {
    super("Invalid " + clazz.getSimpleName());
  }
}
