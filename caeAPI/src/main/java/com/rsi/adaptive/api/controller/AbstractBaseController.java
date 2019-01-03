package com.rsi.adaptive.api.controller;

import com.rsi.adaptive.api.controller.enums.AdaptiveEndpoint;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

/**
 * Created by suryadevarap on 12/20/18.
 */
public abstract class AbstractBaseController {


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(
      value = {
          EmptyResultDataAccessException.class,
          EntityNotFoundException.class
      }
  )
  public void handleNotFound() {}

  protected void checkForVersion(String version, AdaptiveEndpoint adaptiveEndpoint){

  }
}

