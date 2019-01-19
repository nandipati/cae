package com.rsi.adaptive.api.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by suryadevarap on 1/17/19.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = -3121508631111536854L;
  private String message;

  public NotFoundException() { }

  public NotFoundException(String message) { this.message = message; }

  public String getMessage() { return message; }

  public void setMessage(String message) { this.message = message; }

}

