package com.Portofolio.service;

import com.Portofolio.dto.RegisterRequest;
import com.Portofolio.dto.UsersDTO;
import com.Portofolio.model.Users;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String register(RegisterRequest registerDto);
    boolean isEmailExist(String email);
    Users getByEmail(String email);
    Users getByName(String name);

    Claims getUserByJwt(String token);

    Users addUser(Users users);
//
//    UsersDTO LoginRequestChecker(LoginRequest loginRequest);
}
