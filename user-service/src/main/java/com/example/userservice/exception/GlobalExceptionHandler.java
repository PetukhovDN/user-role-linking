package com.example.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the application.
 * This class handles exceptions thrown by the application
 * and provides a centralized way to manage error responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Handles all exceptions that are not explicitly handled.
   *
   * @param ex the exception that was thrown
   * @return a ResponseEntity containing the error message and HTTP status
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleAllExceptions(Exception ex) {
    // Return an internal server error response with the exception message
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
  }

}
