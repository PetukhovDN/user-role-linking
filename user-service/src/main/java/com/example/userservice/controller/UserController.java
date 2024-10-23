package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * Retrieves a list of all users.
   *
   * @return a list of UserDto objects
   */
  @GetMapping
  public List<UserDto> getAllUsers() {
    return userService.getAllUsers();
  }

  /**
   * Retrieves a user by its ID.
   *
   * @param id the ID of the user to retrieve
   * @return ResponseEntity containing the UserDto object if found
   * @throws UserNotFoundException if the user is not found
   */
  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
    UserDto userDto = userService.getUserById(id);
    if (userDto == null) {
      throw new UserNotFoundException("User with ID " + id + " not found.");
    }
    return ResponseEntity.ok(userDto);
  }

  /**
   * Creates a new user.
   *
   * @param userDto the UserDto object to create
   * @return ResponseEntity containing the created UserDto object
   */
  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
    return ResponseEntity.ok(userService.createUser(userDto));
  }

  /**
   * Updates an existing user by its ID.
   *
   * @param id      the ID of the user to update
   * @param userDto the updated UserDto object
   * @return ResponseEntity containing the updated UserDto object
   */
  @PutMapping("/{id}")
  public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
    return ResponseEntity.ok(userService.updateUser(id, userDto));
  }

  /**
   * Deletes a user by its ID.
   *
   * @param id the ID of the user to delete
   * @return ResponseEntity with no content status
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }

}
