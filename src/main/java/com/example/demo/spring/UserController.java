package com.example.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class UserController {
  @Autowired SpringUserService service;

  @GetMapping("/user/{userId}")
  public ResponseEntity<String> getUserName(@PathVariable("userId") int userId) {
    String userName = null;
    return ResponseEntity.ok(service.getUserName(userId));
  }
}
