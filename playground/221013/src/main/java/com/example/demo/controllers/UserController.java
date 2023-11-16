package com.example.demo.controllers;

import com.example.demo.models.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @PostMapping("/user")
  public User user(@ModelAttribute User user) {
    return user;
  }
}
