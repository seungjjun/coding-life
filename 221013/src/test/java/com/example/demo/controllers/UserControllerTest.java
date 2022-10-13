package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserControllerTest {
  @Autowired
  private MockMvc mockMvc;


  @Test
  void useRequestBody() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/user")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"name\":\"jun\"," +
                " \"age\":25" +
                "}"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("\"name\":\"jun\"")
        ));
  }

  @Test
  void userModelAttribute() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/user")
            .param("name", "jun")
            .param("age", "25"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("\"name\":\"jun\"")
        ));
  }
}
