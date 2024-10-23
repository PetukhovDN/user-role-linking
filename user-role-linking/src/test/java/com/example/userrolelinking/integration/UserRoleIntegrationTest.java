package com.example.userrolelinking.integration;

import com.example.roleservice.config.SecurityConfig;
import com.example.userrolelinking.controller.UserRoleController;
import com.example.userrolelinking.dto.UserRoleDto;
import com.example.userrolelinking.service.UserRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRoleController.class)
@Import(SecurityConfig.class)
class UserRoleIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserRoleService userRoleService;


  @Test
  void testAddUserRole() throws Exception {
    when(userRoleService.addUserRole(1L, 1L)).thenReturn(new UserRoleDto(1L, 1L));

    mockMvc.perform(post("/api/users/1/roles/1")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

}
