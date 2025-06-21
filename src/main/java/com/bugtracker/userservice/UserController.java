package com.bugtracker.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    private final RestTemplate restTemplate = new RestTemplate();

    public static class Info {
        public String name;
        public int age;
    }

    @GetMapping("/test")
    public String test() {
        return "This is a test - user-service" + "\n\n";
    }

    @GetMapping("/users/projects-status")
    public String projectStatus() {
        String response = restTemplate.getForObject("http://project-service:8082/test", String.class);
        return "Project Service says: " + response + "\n\n";
    }

    @PostMapping("/info")
    public String receiveInfo(@RequestBody Info info) {
        return "Hello, " + info.name + ", age " + info.age + "\n\n";
    }
}