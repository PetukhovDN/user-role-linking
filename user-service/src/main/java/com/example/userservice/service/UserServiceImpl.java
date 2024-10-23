package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  /**
   * Retrieves a list of UserDto objects representing all users.
   *
   * @return a list of UserDto objects
   */
  @Override
  public List<UserDto> getAllUsers() {
    log.info("Fetching all users");
    return userRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
  }

  /**
   * Retrieves a UserDto object associated with the specified user ID.
   *
   * @param id the ID of the user to be retrieved
   * @return a UserDto object representing the user
   */
  @Override
  public UserDto getUserById(Long id) {
    log.info("Fetching user with ID: {}", id);
    return convertToDto(userRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException("User not found with id: " + id)));
  }

  /**
   * Creates a new user based on the provided UserDto object.
   *
   * @param userDto the UserDto object containing user details
   * @return the created UserDto object
   */
  @Override
  public UserDto createUser(UserDto userDto) {
    log.info("Creating new user with username: {}", userDto.getUsername());
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    user.setCreatedAt(LocalDateTime.now());
    user.setUpdatedAt(LocalDateTime.now());
    return convertToDto(userRepository.save(user));
  }

  /**
   * Updates an existing user based on the provided UserDto object.
   *
   * @param id      the ID of the user to be updated
   * @param userDto the UserDto object containing updated user details
   * @return the updated UserDto object
   */
  @Override
  public UserDto updateUser(Long id, UserDto userDto) {
    log.info("Updating user with ID: {}", id);
    User user = userRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException("User not found with id: " + id));
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setPassword(passwordEncoder.encode(userDto.getPassword())); // Encrypt the password
    user.setUpdatedAt(LocalDateTime.now());
    return convertToDto(userRepository.save(user));
  }

  /**
   * Deletes a user by ID.
   *
   * @param id the ID of the user to be deleted
   */
  @Override
  public void deleteUser(Long id) {
    log.info("Deleting user with ID: {}", id);
    userRepository.deleteById(id);
  }

  private UserDto convertToDto(User user) {
    UserDto dto = new UserDto();
    dto.setId(user.getId());
    dto.setUsername(user.getUsername());
    dto.setEmail(user.getEmail());
    return dto;
  }

}
