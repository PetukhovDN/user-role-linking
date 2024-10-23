package com.example.roleservice.controller;

import com.example.roleservice.dto.RoleDto;
import com.example.roleservice.service.RoleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoleControllerTest {

  @Mock
  private RoleService roleService;

  @InjectMocks
  private RoleController roleController;

  public RoleControllerTest() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetRoleById() {
    RoleDto roleDto = new RoleDto();
    roleDto.setName("Admin");

    when(roleService.getRoleById(1L)).thenReturn(roleDto);

    ResponseEntity<RoleDto> response = roleController.getRoleById(1L);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Admin", response.getBody().getName());
  }

}
