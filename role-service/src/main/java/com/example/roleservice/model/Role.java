package com.example.roleservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a Role in the system.
 * This class is mapped to the 'roles' table in the database.
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

  /**
   * The unique identifier for the role.
   * This field is automatically generated using an identity strategy.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * The name of the role.
   * This field must be unique.
   */
  @Column(unique = true)
  private String name;

  /**
   * A brief description of the role.
   */
  @Column
  private String description;

}
