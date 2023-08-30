package com.Portofolio.service;

import com.Portofolio.model.UserRoleAproval;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleAprovalService {
    UserRoleAproval addRequest(UserRoleAproval userRoleAproval);
}
