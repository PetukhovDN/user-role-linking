package com.example.userrolelinking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a user-role association is not found.
 * This will result in a 404 Not Found HTTP response status.
 */
@ResponseStatus(HttpStatus.NOT_FOUND) // Returns 404 Not Found
public class UserRoleNotFoundException extends RuntimeException {

  public UserRoleNotFoundException() {
    super("User role not found");
  }

  public UserRoleNotFoundException(String message) {
    super(message);
  }

  public UserRoleNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserRoleNotFoundException(Throwable cause) {
    super(cause);
  }

}
