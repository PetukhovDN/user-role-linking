package com.example.roleservice.integration;

import com.example.roleservice.config.SecurityConfig;
import com.example.roleservice.controller.RoleController;
import com.example.roleservice.dto.RoleDto;
import com.example.roleservice.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoleController.class)
@Import(SecurityConfig.class)
class RoleIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RoleService roleService;

  @Test
  void testGetRoleById() throws Exception {
    when(roleService.getRoleById(1L)).thenReturn(new RoleDto(1L, "Admin", ""));
    mockMvc.perform(get("/api/roles/1")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

}
