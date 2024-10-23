package com.example.userservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entity class representing a User in the system.
 * This class maps to the 'users' table in the database.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

  /**
   * Unique identifier for the user.
   * Automatically generated by the database.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Unique username for the user.
   */
  @Column(unique = true)
  private String username;

  /**
   * Unique email for the user.
   */
  @Column(unique = true)
  private String email;

  /**
   * Password for the user account.
   */
  private String password;

  /**
   * Timestamp indicating when the user was created.
   */
  private LocalDateTime createdAt;

  /**
   * Timestamp indicating when the user was last updated.
   */
  private LocalDateTime updatedAt;

}
