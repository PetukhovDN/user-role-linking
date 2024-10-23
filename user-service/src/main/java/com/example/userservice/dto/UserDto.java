package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for User entity.
 * This class is used to transfer user data between the client and server.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private Long id; // Unique identifier for the user
  private String username; // Username of the user
  private String email; // Email address of the user
  private String password; // Password for user authentication

}
