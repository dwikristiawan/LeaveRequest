package com.Portofolio.dto;

import com.Portofolio.model.Department;
import com.Portofolio.model.Manager;
import com.Portofolio.model.StatusAproval;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class RequestUsersRoleDTO {
    private String department;
    private String manager;

}
