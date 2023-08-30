package com.Portofolio.service;

import com.Portofolio.model.StatusAproval;
import org.springframework.stereotype.Service;

@Service
public interface StatusAprovalService {
    StatusAproval getByStatus(String status);
}
