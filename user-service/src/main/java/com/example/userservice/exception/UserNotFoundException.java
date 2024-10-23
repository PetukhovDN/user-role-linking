package com.example.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a user is not found in the system.
 * This exception is annotated with @ResponseStatus to return a
 * 404 Not Found response when it is thrown.
 */
@ResponseStatus(HttpStatus.NOT_FOUND) // Returns 404 Not Found
public class UserNotFoundException extends RuntimeException {

  /**
   * Default constructor that creates a new UserNotFoundException
   * with a default message.
   */
  public UserNotFoundException() {
    super("User not found");
  }

  /**
   * Constructor that creates a new UserNotFoundException with a custom message.
   *
   * @param message the custom message
   */
  public UserNotFoundException(String message) {
    super(message);
  }

  /**
   * Constructor that creates a new UserNotFoundException with a custom message
   * and a cause.
   *
   * @param message the custom message
   * @param cause the cause of the exception
   */
  public UserNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructor that creates a new UserNotFoundException with a cause.
   *
   * @param cause the cause of the exception
   */
  public UserNotFoundException(Throwable cause) {
    super(cause);
  }

}
