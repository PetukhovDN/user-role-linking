package com.example.userservice.integration;

import com.example.userservice.config.SecurityConfig;
import com.example.userservice.controller.UserController;
import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
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

@WebMvcTest(UserController.class)
@Import(SecurityConfig.class)
class UserIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  void testGetUserById() throws Exception {
    when(userService.getUserById(1L)).thenReturn(new UserDto());

    mockMvc.perform(get("/api/users/1")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

}
