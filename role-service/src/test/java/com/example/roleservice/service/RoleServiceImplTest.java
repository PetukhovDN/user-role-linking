package com.example.roleservice.service;

import com.example.roleservice.dto.RoleDto;
import com.example.roleservice.model.Role;
import com.example.roleservice.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoleServiceImplTest {

  @InjectMocks
  private RoleServiceImpl roleService;

  @Mock
  private RoleRepository roleRepository;

  private Role role;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    role = new Role();
    role.setId(1L);
    role.setName("ROLE_USER");
  }

  @Test
  void getAllRoles() {
    when(roleRepository.findAll()).thenReturn(Arrays.asList(role));
    List<RoleDto> roles = roleService.getAllRoles();
    assertEquals(1, roles.size());
  }

  @Test
  void getRoleById() {
    when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
    RoleDto roleDto = roleService.getRoleById(1L);
    assertEquals("ROLE_USER", roleDto.getName());
  }

  @Test
  void createRole() {
    RoleDto roleDto = new RoleDto();
    roleDto.setName("ROLE_ADMIN");

    when(roleRepository.save(any(Role.class))).thenReturn(role);
    RoleDto createdRole = roleService.createRole(roleDto);
    assertEquals("ROLE_USER", createdRole.getName());
  }

  @Test
  void updateRole() {
    when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
    RoleDto roleDto = new RoleDto();
    roleDto.setName("ROLE_ADMIN");

    Role roleToSave = new Role();
    roleToSave.setId(role.getId());
    roleToSave.setName("ROLE_ADMIN");
    when(roleRepository.save(any(Role.class))).thenReturn(roleToSave);

    RoleDto updatedRole = roleService.updateRole(1L, roleDto);
    assertEquals("ROLE_ADMIN", updatedRole.getName());
  }

  @Test
  void deleteRole() {
    roleService.deleteRole(1L);
    verify(roleRepository).deleteById(1L);
  }
}
