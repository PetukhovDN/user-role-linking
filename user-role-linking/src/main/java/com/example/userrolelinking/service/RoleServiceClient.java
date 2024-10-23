package com.example.userrolelinking.service;

import com.example.roleservice.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service client for interacting with the Role Service.
 * This class uses RestTemplate to make HTTP requests to the Role Service API.
 */
@Service
public class RoleServiceClient {

  @Autowired
  private RestTemplate restTemplate;

  /**
   * Retrieves a RoleDto object by its role ID from the Role Service.
   *
   * @param roleId the ID of the role to be retrieved
   * @return the RoleDto associated with the given role ID
   */
  public RoleDto getRoleById(Long roleId) {
    String url = "http://localhost:8082/api/roles/" + roleId;
    return restTemplate.getForObject(url, RoleDto.class);
  }

}
