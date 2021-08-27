package com.abhijind.userservice.controller;

import com.abhijind.userservice.entity.User;
import com.abhijind.userservice.service.UserService;
import com.abhijind.userservice.valueobjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplateVO> getById(@PathVariable("id") Long id) {
        log.info("User Controller: get user with dept.");
        return ResponseEntity.ok().body(userService.getByIdWithDept(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody User user) {
        log.info("User Controller: save user");
        return ResponseEntity.ok().body(userService.save(user));
    }

}
