package com.bugtracker.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/test")
    public String test() {
        return "This is a test - user-service";
    }

    @GetMapping("/users/projects-status")
    public String projectStatus() {
        String response = restTemplate.getForObject("http://project-service:8082/test", String.class);
        return "Project Service says: " + response;
    }
}
