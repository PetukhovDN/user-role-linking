package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

  @InjectMocks
  private UserServiceImpl userService;

  @Mock
  private UserRepository userRepository;

  private User user;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    user = new User();
    user.setId(1L);
    user.setUsername("testuser");
    user.setPassword("testuser_password");
    user.setEmail("test@example.com");
  }

  @Test
  void getAllUsers() {
    when(userRepository.findAll()).thenReturn(Arrays.asList(user));
    List<UserDto> users = userService.getAllUsers();
    assertEquals(1, users.size());
  }

  @Test
  void getUserById() {
    when(userRepository.findById(1L)).thenReturn(Optional.of(user));
    UserDto userDto = userService.getUserById(1L);
    assertEquals("testuser", userDto.getUsername());
  }

  @Test
  void createUser() {
    UserDto userDto = new UserDto();
    userDto.setUsername("newuser");
    userDto.setEmail("new@example.com");
    userDto.setPassword("password");

    when(userRepository.save(any(User.class))).thenReturn(user);
    UserDto createdUser = userService.createUser(userDto);
    assertEquals("testuser", createdUser.getUsername());
  }

  @Test
  void updateUser() {
    when(userRepository.findById(1L)).thenReturn(Optional.of(user));
    when(userRepository.save(any(User.class))).thenReturn(user);

    UserDto userDto = new UserDto();
    userDto.setUsername("updateduser");
    userDto.setPassword("updateduser_password");

    UserDto updatedUser = userService.updateUser(1L, userDto);
    assertEquals("updateduser", updatedUser.getUsername());
  }

  @Test
  void deleteUser() {
    userService.deleteUser(1L);
    verify(userRepository).deleteById(1L);
  }

}
