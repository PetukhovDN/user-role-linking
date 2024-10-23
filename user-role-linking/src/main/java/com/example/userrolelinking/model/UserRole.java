package com.example.userrolelinking.model;

import com.example.userservice.model.User;
import com.example.roleservice.model.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing the association between a user and a role.
 * This class maps to the 'user_roles' table in the database.
 */
@Entity
@Table(name = "user_roles")
@Getter
@Setter
public class UserRole {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // Unique identifier for the user-role association

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false) // Foreign key to the User entity
  private User user; // The user associated with the role

  @ManyToOne
  @JoinColumn(name = "role_id", nullable = false) // Foreign key to the Role entity
  private Role role; // The role assigned to the user

}
