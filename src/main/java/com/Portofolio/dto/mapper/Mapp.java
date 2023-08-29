package com.Portofolio.dto.mapper;

import com.Portofolio.dto.ProfileDTO;
import com.Portofolio.dto.RegisterRequest;
import com.Portofolio.dto.RoleDTO;
import com.Portofolio.dto.UsersDTO;
import com.Portofolio.model.Roles;
import com.Portofolio.model.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
@Component
public class Mapp {
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
        profileDTO.setBirth(users.getBirth().toString());
        profileDTO.setGender(users.getGender());
        profileDTO.setTelpon(users.getTelpon());
        profileDTO.setAddress(users.getAddress());
        return profileDTO;
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
}
