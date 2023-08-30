package com.Portofolio.dto;

import com.Portofolio.model.Department;
import com.Portofolio.model.Manager;
import com.Portofolio.model.StatusAproval;
import com.Portofolio.model.Users;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Data
@Getter
@Setter
public class UsersAprovalDto{
        private Users users;
        private Department department;
        private Manager manager;
        private StatusAproval statusAproval;
}
