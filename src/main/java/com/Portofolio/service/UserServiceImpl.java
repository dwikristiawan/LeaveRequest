package com.Portofolio.service;

import com.Portofolio.dto.RegisterRequest;
import com.Portofolio.dto.UsersDTO;
import com.Portofolio.dto.mapper.Mapp;
import com.Portofolio.model.UserRole;
import com.Portofolio.model.Users;
import com.Portofolio.repository.RoleRepository;
import com.Portofolio.repository.UserRepository;
import com.Portofolio.repository.UserRoleRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserServiceImpl implements UserService{
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    Mapp mapp;
    @Override
    public String register(RegisterRequest registerDto) {
        Users users=new Users();
        UserRole userRole=new UserRole();
        users=mapp.reqisterDtoToUsers(registerDto);
        userRole.setRoles(roleRepository.getByName("USER"));
        userRoleRepository.save(userRole);
        users.setRole(userRoleRepository.getReferenceById(userRole.getId()));
        userRepository.save(users);
        return "register success";
    }

    @Override
    public boolean isEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Users getByEmail(String email) {
        Users users=userRepository.findByEmail(email);
        return users;
    }

    @Override
    public Users getByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Claims getUserByJwt(String token) {
        Claims claims= Jwts.claims();
        return claims;
    }

    @Override
    public Users addUser(Users users) {
        return userRepository.save(users);
    }

//    @Override
//    public UsersDTO LoginRequestChecker(LoginRequest loginRequest) {
//        UsersDTO usersDTO=new UsersDTO();
//        Users users=new Users();
//        usersDTO=getByEmailToDto(loginRequest.getEmail());
//        users=userRepository.findByEmail(loginRequest.getEmail());
//
//
//        if (usersDTO==null){
//
//            return null;
//        }
//        if(!PasswordEncoder.isPasswordValid(loginRequest.getPassword(),users.getPassword())){
//
//            return null;
//        }
//        return usersDTO ;
//
//    }
}
