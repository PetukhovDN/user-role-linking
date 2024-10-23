package com.example.userservice.mapper;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;
import org.springframework.stereotype.Component;

/**
 * Mapper class for converting between User and UserDto objects.
 * This class provides methods to convert User entities to
 * User Data Transfer Objects (DTOs) and vice versa.
 */
@Component
public class UserMapper {

  /**
   * Converts a User entity to a UserDto.
   *
   * @param user the User entity to be converted
   * @return a UserDto representing the User entity
   */
  public UserDto toDto(User user) {
    UserDto dto = new UserDto();
    dto.setId(user.getId());
    dto.setUsername(user.getUsername());
    dto.setEmail(user.getEmail());
    return dto;
  }

  /**
   * Converts a UserDto to a User entity.
   *
   * @param dto the UserDto to be converted
   * @return a User entity representing the UserDto
   */
  public User toEntity(UserDto dto) {
    User user = new User();
    user.setId(dto.getId());
    user.setUsername(dto.getUsername());
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());
    return user;
  }

}
