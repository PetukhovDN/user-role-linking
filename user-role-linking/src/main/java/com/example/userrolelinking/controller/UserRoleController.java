package com.example.userrolelinking.controller;

import com.example.userrolelinking.dto.UserRoleDto;
import com.example.userrolelinking.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing user roles.
 * Provides endpoints for adding, retrieving, and removing roles from users.
 */
@Slf4j
@RestController
@RequestMapping("/api/users/{userId}/roles")
public class UserRoleController {

  @Autowired
  private UserRoleService userRoleService;

  /**
   * Retrieves all roles assigned to a specific user.
   *
   * @param userId the ID of the user
   * @return a list of UserRoleDto objects representing the user's roles
   */
  @GetMapping
  public ResponseEntity<List<UserRoleDto>> getUserRoles(@PathVariable Long userId) {
    log.info("Fetching roles for user with ID: {}", userId);
    List<UserRoleDto> roles = userRoleService.getUserRolesByUserId(userId);
    return ResponseEntity.ok(roles);
  }

  /**
   * Adds a role to a user.
   *
   * @param userId the ID of the user
   * @param roleId the ID of the role to assign
   * @return a UserRoleDto object representing the newly assigned role
   */
  @PostMapping("/{roleId}")
  public ResponseEntity<UserRoleDto> addUserRole(@PathVariable Long userId, @PathVariable Long roleId) {
    log.info("Adding role with ID: {} to user with ID: {}", roleId, userId);
    UserRoleDto userRole = userRoleService.addUserRole(userId, roleId);
    log.info("Role with ID: {} successfully added to user with ID: {}", roleId, userId);
    return ResponseEntity.ok(userRole);
  }

  /**
   * Removes a role from a user.
   *
   * @param userId the ID of the user
   * @param roleId the ID of the role to remove
   * @return a ResponseEntity with no content upon successful removal
   */
  @DeleteMapping("/{roleId}")
  public ResponseEntity<Void> removeUserRole(@PathVariable Long userId, @PathVariable Long roleId) {
    log.info("Removing role with ID: {} from user with ID: {}", roleId, userId);
    userRoleService.removeUserRole(userId, roleId);
    log.info("Role with ID: {} successfully removed from user with ID: {}", roleId, userId);
    return ResponseEntity.noContent().build();
  }

}
