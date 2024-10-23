package com.example.roleservice.service;

import com.example.roleservice.dto.RoleDto;
import com.example.roleservice.model.Role;
import com.example.roleservice.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing roles.
 * Provides methods for CRUD operations on roles.
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository roleRepository;

  /**
   * Retrieves all roles from the repository and converts them to RoleDto objects.
   *
   * @return a list of RoleDto objects
   */
  @Override
  public List<RoleDto> getAllRoles() {
    log.info("Fetching all roles");
    return roleRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
  }

  /**
   * Retrieves a role by its ID, throws an exception if not found.
   *
   * @param id the ID of the role to retrieve
   * @return a RoleDto object representing the role
   */
  @Override
  public RoleDto getRoleById(Long id) {
    log.info("Fetching role with ID: {}", id);
    return convertToDto(roleRepository.findById(id).orElseThrow(() -> {
      log.error("Role with ID: {} not found", id);
      return new RuntimeException("Role not found");
    }));
  }

  /**
   * Creates a new role in the repository.
   *
   * @param roleDto the role data to create
   * @return a RoleDto object representing the newly created role
   */
  @Override
  public RoleDto createRole(RoleDto roleDto) {
    log.info("Creating new role: {}", roleDto);
    Role role = new Role();
    role.setName(roleDto.getName());
    role.setDescription(roleDto.getDescription());
    Role savedRole = roleRepository.save(role);
    log.info("Role created successfully with ID: {}", savedRole.getId());
    return convertToDto(savedRole);
  }

  /**
   * Updates an existing role in the repository.
   *
   * @param id      the ID of the role to update
   * @param roleDto the updated role data
   * @return a RoleDto object representing the updated role
   */
  @Override
  public RoleDto updateRole(Long id, RoleDto roleDto) {
    log.info("Updating role with ID: {}", id);
    Role role = roleRepository.findById(id).orElseThrow(() -> {
      log.error("Role with ID: {} not found", id);
      return new RuntimeException("Role not found");
    });
    role.setName(roleDto.getName());
    role.setDescription(roleDto.getDescription());
    Role updatedRole = roleRepository.save(role);
    log.info("Role updated successfully with ID: {}", updatedRole.getId());
    return convertToDto(updatedRole);
  }

  /**
   * Deletes a role by its ID.
   *
   * @param id the ID of the role to delete
   */
  @Override
  public void deleteRole(Long id) {
    log.info("Deleting role with ID: {}", id);
    roleRepository.deleteById(id);
    log.info("Role with ID: {} deleted successfully", id);
  }

  /**
   * Converts a Role entity to a RoleDto object.
   *
   * @param role the Role entity to convert
   * @return the RoleDto object
   */
  private RoleDto convertToDto(Role role) {
    RoleDto dto = new RoleDto();
    dto.setId(role.getId());
    dto.setName(role.getName());
    dto.setDescription(role.getDescription());
    return dto;
  }

}
