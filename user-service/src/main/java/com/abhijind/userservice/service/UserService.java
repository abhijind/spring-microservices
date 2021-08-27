package com.abhijind.userservice.service;

import com.abhijind.userservice.entity.User;
import com.abhijind.userservice.repository.UserRepository;
import com.abhijind.userservice.valueobjects.Department;
import com.abhijind.userservice.valueobjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserService {

    private final RestTemplate restTemplate;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User save(User user) {
        log.info("User Service: save user");
        return userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with given id not found"));
    }

    public ResponseTemplateVO getByIdWithDept(Long id) {
        log.info("User Service: get user with dept.");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with given id not found"));
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
