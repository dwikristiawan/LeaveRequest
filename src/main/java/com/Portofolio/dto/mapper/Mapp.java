package com.Portofolio.dto.mapper;

import com.Portofolio.dto.*;
import com.Portofolio.model.UserRoleAproval;
import com.Portofolio.model.Users;
import com.Portofolio.service.DepartmentService;
import com.Portofolio.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Mapp {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    ManagerService managerService;
    public UsersDTO usersToDTO(Users users){
        UsersDTO usersDTO=new UsersDTO();
        usersDTO.setId(users.getId());
        usersDTO.setUsername(users.getUsername());
        usersDTO.setEmail(users.getEmail());
        usersDTO.setPassword(users.getPassword());
        usersDTO.setRoles(users.getRole().getRoles().getName());

        return usersDTO;
    }
    public ProfileDTO usersToProfileDto(Users users){
        ProfileDTO profileDTO=new ProfileDTO();
        profileDTO.setUsername(users.getUsername());
        profileDTO.setEmail(users.getEmail());
        String strDate=null;
        if (users.getBirth()!=null){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            strDate=dateFormat.format(users.getBirth());
        }
        profileDTO.setBirth(strDate);
        profileDTO.setGender(users.getGender());
        profileDTO.setTelpon(users.getTelpon());
        profileDTO.setAddress(users.getAddress());
        return profileDTO;
    }
    public Users profilDtoToUsers(ProfileDTO profileDTO,Users users) throws ParseException {
        users.setUsername(profileDTO.getUsername());
        users.setEmail(profileDTO.getEmail());
        users.setTelpon(profileDTO.getTelpon());
        users.setGender(profileDTO.getGender());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(profileDTO.getBirth());
        users.setBirth(date);
        users.setAddress(profileDTO.getAddress());
        return users;

    }

//    public Collection<RoleDTO> RoleToDTO(Roles roles){
//        Collection<RoleDTO> roleDtos = new ArrayList<>();
//        RoleDTO roleDTO=new RoleDTO();
//        roleDTO.setRoles(roles.getName());
//        roleDtos.add(roleDTO);
//        return roleDtos;
//    }
    public  Users reqisterDtoToUsers(RegisterRequest registerDto){
        Users users=new Users();
        users.setUsername(registerDto.getUsername());
        users.setEmail(registerDto.getEmail());
        users.setPassword(registerDto.getPassword());
        return users;
    }
    public UserRoleAproval userAprovalToUserAproval(RequestUsersRoleDTO requestUsersRoleDTO){
        UserRoleAproval userRoleAproval=new UserRoleAproval();
        userRoleAproval.setDepartment(departmentService.getByName(requestUsersRoleDTO.getDepartment()));
        userRoleAproval.setManager(managerService.getByName(requestUsersRoleDTO.getManager()));
        return userRoleAproval;
    }
}
