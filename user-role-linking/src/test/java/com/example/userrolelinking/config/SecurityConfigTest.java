package com.example.userrolelinking.config;

import com.example.userrolelinking.UserRoleLinkingApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = UserRoleLinkingApplication.class)
@AutoConfigureMockMvc
class SecurityConfigTest {

  @Autowired
  private MockMvc mockMvc;

//  @Test
//  @WithMockUser
//  void testProtectedEndpoint() throws Exception {
//    mockMvc.perform(get("/api/users/1/roles")
//                    .with(authentication(null)))
//            .andExpect(status().isOk());
//  }

  @Test
  void testUnprotectedEndpoint() throws Exception {
    mockMvc.perform(get("/api/users/1/roles"))
            .andExpect(status().isOk());
  }
}
