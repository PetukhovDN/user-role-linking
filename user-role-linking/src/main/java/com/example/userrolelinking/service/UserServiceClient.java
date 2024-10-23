package com.example.userrolelinking.service;

import com.example.userservice.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserServiceClient {

  @Autowired
  private RestTemplate restTemplate;

  /**
   * Retrieves a UserDto object by user ID.
   *
   * @param userId the ID of the user to be retrieved
   * @return the UserDto object associated with the specified user ID
   */
  public UserDto getUserById(Long userId) {
    String url = "http://localhost:8081/api/users/" + userId;
    log.info("Fetching user with ID: {}", userId);
    UserDto userDto = restTemplate.getForObject(url, UserDto.class);
    if (userDto == null) {
      log.warn("No user found with ID: {}", userId);
    }
    return userDto;
  }

}
