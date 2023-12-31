package com.Portofolio.controller;

import com.Portofolio.dto.LoginRequest;
import com.Portofolio.dto.RegisterRequest;
import com.Portofolio.dto.ProfileDTO;
import com.Portofolio.dto.RequestUsersRoleDTO;
import com.Portofolio.dto.mapper.Mapp;
import com.Portofolio.model.UserRoleAproval;
import com.Portofolio.model.Users;
import com.Portofolio.service.UserService;
import com.Portofolio.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    Mapp mapp;
    @PostMapping("/auth/register")
    ResponseEntity register(@RequestBody RegisterRequest registerDto){
        registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        try {
            if(userService.isEmailExist(registerDto.getEmail())){
                return ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .body("email has been used");
            }else{
                return ResponseEntity
                        .ok()
                        .body(userService.register(registerDto));
            }
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e);
        }
    }
    @PostMapping("/auth/login")
    ResponseEntity login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) throws Exception {
        try {
//            if(!userService.isEmailExist(loginRequest.getEmail())){
//                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid username or password");
//            }
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        }catch (BadCredentialsException e){ throw new Exception("Invalid username or password",e);}

        final UserDetails userDetails=userDetailsService.loadUserByUsername(loginRequest.getEmail());
        final String token=jwtUtils.generateToken(userDetails);
        Cookie cookie=new Cookie("jwt",token);
        response.addCookie(cookie);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Login Success");
    }
    @GetMapping("/profile")
    ResponseEntity showProfile(@RequestHeader("Authorization") String auth){
        try {
            String token = auth.substring("Bearer ".length());
            Users users = userService.getByEmail(jwtUtils.extractUsername(token));
            ProfileDTO profileDTO = mapp.usersToProfileDto(users);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(profileDTO);
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e);
        }
    }
    @PutMapping("/update-profile")
    ResponseEntity updateProfile(@RequestBody(required = true) ProfileDTO updateProfileRequest,@RequestHeader("Authorization") String auth) throws ParseException {
        try {
            String token = auth.substring("Bearer ".length());
            Users users = userService.getByEmail(jwtUtils.extractUsername(token));
            users = mapp.profilDtoToUsers(updateProfileRequest, users);
            users.setComplated(true);
            users = userService.addUser(users);
            ProfileDTO profileDTO=mapp.usersToProfileDto(users);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(profileDTO);
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e);
        }
    }




}
