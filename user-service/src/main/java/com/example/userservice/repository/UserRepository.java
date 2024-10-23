package com.example.userservice.repository;

import com.example.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing User entities.
 * This interface provides methods to perform CRUD operations on the User table.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * Checks if a user exists with the given username.
   *
   * @param username the username to check for existence
   * @return true if a user with the given username exists, false otherwise
   */
  boolean existsByUsername(String username);

  /**
   * Checks if a user exists with the given email.
   *
   * @param email the email to check for existence
   * @return true if a user with the given email exists, false otherwise
   */
  boolean existsByEmail(String email);

}
