package com.example.userrolelinking.controller;

import com.example.userrolelinking.dto.UserRoleDto;
import com.example.userrolelinking.service.UserRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserRoleControllerTest {

  @Mock
  private UserRoleService userRoleService;

  @InjectMocks
  private UserRoleController userRoleController;

  public UserRoleControllerTest() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testAddUserRole() {
    UserRoleDto userRoleDto = new UserRoleDto();
    userRoleDto.setUserId(1L);
    userRoleDto.setRoleId(1L);

    when(userRoleService.addUserRole(1L, 1L)).thenReturn(userRoleDto);

    ResponseEntity<UserRoleDto> response = userRoleController.addUserRole(1L, 1L);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(1L, response.getBody().getUserId());
  }

}
