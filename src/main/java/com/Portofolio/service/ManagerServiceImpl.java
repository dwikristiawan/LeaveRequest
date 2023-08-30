package com.Portofolio.service;

import com.Portofolio.model.Manager;
import com.Portofolio.repository.ManagerRepository;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    ManagerRepository managerRepository;
    @Override
    public Manager getByName(String name) {
        return managerRepository.getByName(name);
    }
}
