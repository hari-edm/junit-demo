package com.example.demo.spring;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired UserController controller;

  @MockBean SpringUserService service;

  @Autowired MockMvc mockMvc;

  @AfterEach
  void tearDown() {
    reset(service);
  }

  @Test
  void testGetUser() throws Exception {
    // given
    when(service.getUserName(10)).thenReturn("test-user");
    // when
    mockMvc
        .perform(MockMvcRequestBuilders.get("/v1/api/user/10"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("test-user"));
  }
}
