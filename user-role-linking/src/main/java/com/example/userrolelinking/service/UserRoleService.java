package com.example.userrolelinking.service;

import com.example.userrolelinking.dto.UserRoleDto;

import java.util.List;

/**
 * Service interface for managing user-role associations.
 * This interface defines the operations that can be performed
 * on user roles within the application.
 */
public interface UserRoleService {

  /**
   * Retrieves a list of UserRoleDto objects associated with the specified user ID.
   *
   * @param userId the ID of the user whose roles are to be retrieved
   * @return a list of UserRoleDto objects associated with the user
   */
  List<UserRoleDto> getUserRolesByUserId(Long userId);

  /**
   * Adds a new user-role association.
   *
   * @param userId the ID of the user to whom the role will be assigned
   * @param roleId the ID of the role to be assigned to the user
   * @return the UserRoleDto representing the newly created association
   */
  UserRoleDto addUserRole(Long userId, Long roleId);

  /**
   * Removes a user-role association.
   *
   * @param userId the ID of the user from whom the role will be removed
   * @param roleId the ID of the role to be removed from the user
   */
  void removeUserRole(Long userId, Long roleId);

}
