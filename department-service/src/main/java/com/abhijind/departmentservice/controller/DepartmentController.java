package com.abhijind.departmentservice.controller;

import com.abhijind.departmentservice.entity.Department;
import com.abhijind.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Department department) {
        log.info("inside save department method of department controller");
        return ResponseEntity.ok().body(departmentService.save(department));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(departmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        log.info("inside getById department method of department controller");
        return ResponseEntity.ok().body(departmentService.getById(id));
    }
}
