package com.Portofolio.service;

import com.Portofolio.model.Manager;
import org.springframework.stereotype.Service;

@Service
public interface ManagerService {
    Manager getByName(String name);
}
