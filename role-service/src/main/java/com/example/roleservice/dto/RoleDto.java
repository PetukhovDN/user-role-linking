package com.example.roleservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for Role entity.
 * This class is used to transfer role data between different layers of the application.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

  /**
   * The unique identifier of the role.
   */
  private Long id;

  /**
   * The name of the role.
   */
  private String name;

  /**
   * A brief description of the role.
   */
  private String description;

}
