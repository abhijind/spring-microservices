package com.abhijind.departmentservice.service;

import com.abhijind.departmentservice.entity.Department;
import com.abhijind.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department) {
        log.info("Department Service: save");
        return departmentRepository.save(department);
    }

    public Department getById(Long id) {
        log.info("Department Service: get by id");
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department with given id not found."));
    }

    public List<Department> getAll() {
        log.info("Department Service: get all");
        return departmentRepository.findAll();
    }
}
