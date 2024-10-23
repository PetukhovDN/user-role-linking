package com.example.userrolelinking.repository;

import com.example.userrolelinking.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing user-role associations.
 * This interface extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

  /**
   * Finds all UserRole entities by the specified user ID.
   *
   * @param userId the ID of the user whose roles are to be retrieved
   * @return a list of UserRole entities associated with the user
   */
  List<UserRole> findByUserId(Long userId);

  /**
   * Finds a UserRole entity by the specified user ID and role ID.
   *
   * @param userId the ID of the user
   * @param roleId the ID of the role
   * @return the UserRole entity associated with the user and role
   */
  UserRole findByUserIdAndRoleId(Long userId, Long roleId);

}
