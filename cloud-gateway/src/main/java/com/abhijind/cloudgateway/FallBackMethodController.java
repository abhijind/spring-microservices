package com.abhijind.cloudgateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public ResponseEntity<String> userServiceFallBack() {
        return ResponseEntity.ok().body("User Service not working right now.");
    }

    @GetMapping("/departmentServiceFallBack")
    public ResponseEntity<String> departmentServiceFallBack() {
        return ResponseEntity.ok().body("Department Service not working right now.");
    }

}
