package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;

import java.util.List;

/**
 * Service interface for managing User entities.
 * This interface defines the operations that can be performed on users
 * within the application.
 */
public interface UserService {

  /**
   * Retrieves all users in the system.
   *
   * @return a list of UserDto objects representing all users
   */
  List<UserDto> getAllUsers();

  /**
   * Retrieves a user by their ID.
   *
   * @param id the ID of the user to retrieve
   * @return a UserDto object representing the user, or null if not found
   */
  UserDto getUserById(Long id);

  /**
   * Creates a new user.
   *
   * @param userDto the UserDto containing the user information to create
   * @return the created UserDto object
   */
  UserDto createUser(UserDto userDto);

  /**
   * Updates an existing user.
   *
   * @param id the ID of the user to update
   * @param userDto the UserDto containing the updated user information
   * @return the updated UserDto object
   */
  UserDto updateUser(Long id, UserDto userDto);

  /**
   * Deletes a user by their ID.
   *
   * @param id the ID of the user to delete
   */
  void deleteUser(Long id);

}
