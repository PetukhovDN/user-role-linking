package com.example.roleservice.controller;

import com.example.roleservice.dto.RoleDto;
import com.example.roleservice.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@Slf4j
public class RoleController {

  @Autowired
  private RoleService roleService;

  /**
   * Retrieves all roles from the system.
   *
   * @return a list of RoleDto objects
   */
  @GetMapping
  public List<RoleDto> getAllRoles() {
    log.info("Fetching all roles");
    return roleService.getAllRoles();
  }

  /**
   * Retrieves a role by its ID.
   *
   * @param id the ID of the role
   * @return a ResponseEntity containing the RoleDto object
   */
  @GetMapping("/{id}")
  public ResponseEntity<RoleDto> getRoleById(@PathVariable Long id) {
    log.info("Fetching role with ID: {}", id);
    RoleDto role = roleService.getRoleById(id);
    return ResponseEntity.ok(role);
  }

  /**
   * Creates a new role.
   *
   * @param roleDto the role data to create
   * @return a ResponseEntity containing the newly created RoleDto object
   */
  @PostMapping
  public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) {
    log.info("Creating new role: {}", roleDto);
    RoleDto createdRole = roleService.createRole(roleDto);
    return ResponseEntity.ok(createdRole);
  }

  /**
   * Updates an existing role.
   *
   * @param id      the ID of the role to update
   * @param roleDto the updated role data
   * @return a ResponseEntity containing the updated RoleDto object
   */
  @PutMapping("/{id}")
  public ResponseEntity<RoleDto> updateRole(@PathVariable Long id, @RequestBody RoleDto roleDto) {
    log.info("Updating role with ID: {}, New Data: {}", id, roleDto);
    RoleDto updatedRole = roleService.updateRole(id, roleDto);
    return ResponseEntity.ok(updatedRole);
  }

  /**
   * Deletes a role by its ID.
   *
   * @param id the ID of the role to delete
   * @return a ResponseEntity with no content if the role is deleted successfully
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
    log.info("Deleting role with ID: {}", id);
    roleService.deleteRole(id);
    return ResponseEntity.noContent().build();
  }

}
