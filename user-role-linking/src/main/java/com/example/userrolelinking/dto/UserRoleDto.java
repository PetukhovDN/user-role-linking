package com.example.userrolelinking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for user-role associations.
 * This class is used to transfer user-role data between layers.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDto {

  private Long userId;  // ID of the user
  private Long roleId;  // ID of the role assigned to the user

}
