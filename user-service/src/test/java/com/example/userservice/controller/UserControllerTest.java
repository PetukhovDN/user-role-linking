package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

  @Mock
  private UserService userService;

  @InjectMocks
  private UserController userController;

  public UserControllerTest() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetUserById() {
    UserDto userDto = new UserDto();
    userDto.setUsername("John Doe");

    when(userService.getUserById(1L)).thenReturn(userDto);

    ResponseEntity<UserDto> response = userController.getUserById(1L);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("John Doe", response.getBody().getUsername());
  }

}
