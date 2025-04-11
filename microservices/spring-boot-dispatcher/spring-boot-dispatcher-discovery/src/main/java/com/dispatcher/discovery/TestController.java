package com.dispatcher.discovery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  public TestController() {
  }

  @GetMapping("/health-check")
  public String healthCheck() {
    return "I am fine!";
  }
}
