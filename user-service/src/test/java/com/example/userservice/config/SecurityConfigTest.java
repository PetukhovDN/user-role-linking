package com.example.userservice.config;

import com.example.userservice.UserServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = UserServiceApplication.class)
@AutoConfigureMockMvc
class SecurityConfigTest {

  @Autowired
  private MockMvc mockMvc;

//  @Test
//  @WithMockUser
//  void testProtectedEndpoint() throws Exception {
//    mockMvc.perform(get("/api/users")
//                    .with(authentication(null)))
//            .andExpect(status().isOk());
//  }

  @Test
  void testUnprotectedEndpoint() throws Exception {
    mockMvc.perform(get("/api/users"))
            .andExpect(status().isOk());
  }

}
