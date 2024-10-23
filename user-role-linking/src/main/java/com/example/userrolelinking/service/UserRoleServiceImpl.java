package com.example.userrolelinking.service;

import com.example.roleservice.dto.RoleDto;
import com.example.roleservice.model.Role;
import com.example.userrolelinking.dto.UserRoleDto;
import com.example.userrolelinking.model.UserRole;
import com.example.userrolelinking.repository.UserRoleRepository;
import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserRoleServiceImpl implements UserRoleService {

  @Autowired
  private UserRoleRepository userRoleRepository;

  @Autowired
  private UserServiceClient userServiceClient;

  @Autowired
  private RoleServiceClient roleServiceClient;

  /**
   * Retrieves a list of UserRoleDto objects associated with the specified user ID.
   *
   * @param userId the ID of the user whose roles are to be retrieved
   * @return a list of UserRoleDto objects associated with the user
   */
  @Override
  public List<UserRoleDto> getUserRolesByUserId(Long userId) {
    log.info("Fetching roles for user with ID: {}", userId);
    return userRoleRepository.findByUserId(userId).stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
  }

  /**
   * Adds a new user-role association.
   *
   * @param userId the ID of the user to whom the role will be assigned
   * @param roleId the ID of the role to be assigned to the user
   * @return the UserRoleDto representing the newly created association
   */
  @Override
  public UserRoleDto addUserRole(Long userId, Long roleId) {
    log.info("Adding role with ID: {} to user with ID: {}", roleId, userId);

    UserDto userDto = Optional.ofNullable(userServiceClient.getUserById(userId))
            .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

    RoleDto roleDto = Optional.ofNullable(roleServiceClient.getRoleById(roleId))
            .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));

    User user = convertToUserEntity(userDto);
    Role role = convertToRoleEntity(roleDto);

    UserRole userRole = new UserRole();
    userRole.setUser(user);
    userRole.setRole(role);

    UserRole savedUserRole = userRoleRepository.save(userRole);
    log.info("Role added successfully: {}", savedUserRole);
    return convertToDto(savedUserRole);
  }

  /**
   * Removes a user-role association.
   *
   * @param userId the ID of the user from whom the role will be removed
   * @param roleId the ID of the role to be removed from the user
   */
  @Override
  public void removeUserRole(Long userId, Long roleId) {
    log.info("Removing role with ID: {} from user with ID: {}", roleId, userId);
    UserRole userRole = userRoleRepository.findByUserIdAndRoleId(userId, roleId);
    if (userRole != null) {
      userRoleRepository.delete(userRole);
      log.info("Role removed successfully for user ID: {}", userId);
    } else {
      log.warn("Role not found for user ID: {} and role ID: {}", userId, roleId);
    }
  }

  private User convertToUserEntity(UserDto userDto) {
    User user = new User();
    user.setId(userDto.getId());
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    return user;
  }

  private Role convertToRoleEntity(RoleDto roleDto) {
    Role role = new Role();
    role.setId(roleDto.getId());
    role.setName(roleDto.getName());
    return role;
  }

  private UserRoleDto convertToDto(UserRole userRole) {
    UserRoleDto dto = new UserRoleDto();
    dto.setUserId(userRole.getUser().getId());
    dto.setRoleId(userRole.getRole().getId());
    return dto;
  }

}
