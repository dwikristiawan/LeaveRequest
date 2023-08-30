package com.Portofolio.service;

import com.Portofolio.model.Department;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    public Department getByName(String name);
}
