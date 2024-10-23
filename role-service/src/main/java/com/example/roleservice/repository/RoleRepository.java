package com.example.roleservice.repository;

import com.example.roleservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Role entity.
 * Extends JpaRepository to provide CRUD operations and custom queries for Role entities.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  /**
   * Checks if a role with the given name exists in the database.
   *
   * @param name the name of the role to check
   * @return true if a role with the specified name exists, otherwise false
   */
  boolean existsByName(String name);

}
