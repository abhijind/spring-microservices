package com.abhijind.departmentservice.service;

import com.abhijind.departmentservice.entity.Department;
import com.abhijind.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department getById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department with given id not found."));
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
