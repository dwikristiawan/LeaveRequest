package com.Portofolio.service;

import com.Portofolio.model.Department;
import com.Portofolio.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department getByName(String name) {
        return departmentRepository.getByName(name);
    }
}
