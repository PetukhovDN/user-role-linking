package com.example.roleservice.service;

import com.example.roleservice.dto.RoleDto;
import java.util.List;

/**
 * Service interface for managing roles.
 * This interface defines the operations that can be performed on roles.
 */
public interface RoleService {

  /**
   * Retrieves all roles from the system.
   *
   * @return a list of RoleDto objects representing all roles
   */
  List<RoleDto> getAllRoles();

  /**
   * Retrieves a role by its ID.
   *
   * @param id the ID of the role to retrieve
   * @return a RoleDto object representing the role
   */
  RoleDto getRoleById(Long id);

  /**
   * Creates a new role.
   *
   * @param roleDto the role data to create
   * @return a RoleDto object representing the newly created role
   */
  RoleDto createRole(RoleDto roleDto);

  /**
   * Updates an existing role.
   *
   * @param id      the ID of the role to update
   * @param roleDto the updated role data
   * @return a RoleDto object representing the updated role
   */
  RoleDto updateRole(Long id, RoleDto roleDto);

  /**
   * Deletes a role by its ID.
   *
   * @param id the ID of the role to delete
   */
  void deleteRole(Long id);

}
