package com.Portofolio.service;

import com.Portofolio.model.StatusAproval;
import com.Portofolio.repository.StatusAprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusAprovalServiceImpl implements StatusAprovalService{
    @Autowired
    StatusAprovalRepository statusAprovalRepository;
    @Override
    public StatusAproval getByStatus(String status) {
        return statusAprovalRepository.getByStatus(status);
    }
}
