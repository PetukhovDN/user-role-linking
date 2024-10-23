package com.example.userrolelinking.service;

import com.example.roleservice.dto.RoleDto;
import com.example.userrolelinking.dto.UserRoleDto;
import com.example.userrolelinking.model.UserRole;
import com.example.userrolelinking.repository.UserRoleRepository;
import com.example.roleservice.model.Role;
import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserRoleServiceImplTest {

  @InjectMocks
  private UserRoleServiceImpl userRoleService;

  @Mock
  private UserRoleRepository userRoleRepository;

  @Mock
  private UserServiceClient userServiceClient;

  @Mock
  private RoleServiceClient roleServiceClient;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testAddUserRole() {
    User user = new User();
    user.setId(1L);
    Role role = new Role();
    role.setId(1L);

    UserRole userRole = new UserRole();
    userRole.setUser(user);
    userRole.setRole(role);

    when(userRoleRepository.save(any(UserRole.class))).thenReturn(userRole);
    when(userServiceClient.getUserById(user.getId())).thenReturn(new UserDto());
    when(roleServiceClient.getRoleById(role.getId())).thenReturn(new RoleDto());

    UserRoleDto userRoleDto = userRoleService.addUserRole(user.getId(), role.getId());
    assertEquals(1L, userRoleDto.getUserId());
    assertEquals(1L, userRoleDto.getRoleId());
  }

}
