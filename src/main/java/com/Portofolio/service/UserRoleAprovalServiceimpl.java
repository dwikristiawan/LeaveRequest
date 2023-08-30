package com.Portofolio.service;

import com.Portofolio.model.UserRoleAproval;
import com.Portofolio.repository.UserRoleAprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleAprovalServiceimpl implements  UserRoleAprovalService{
    @Autowired
    UserRoleAprovalRepository userRoleAprovalRepository;
    @Autowired
    StatusAprovalService statusAprovalService;
    public UserRoleAproval addRequest(UserRoleAproval userRoleAproval) {
        userRoleAproval.setStatusAproval(statusAprovalService.getByStatus("WAITING"));
        return userRoleAprovalRepository.save(userRoleAproval);
    }
}
