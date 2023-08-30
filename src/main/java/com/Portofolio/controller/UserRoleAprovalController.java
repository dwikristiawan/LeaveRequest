package com.Portofolio.controller;

import com.Portofolio.dto.RequestUsersRoleDTO;
import com.Portofolio.dto.mapper.Mapp;
import com.Portofolio.model.UserRoleAproval;
import com.Portofolio.model.Users;
import com.Portofolio.service.UserRoleAprovalService;
import com.Portofolio.service.UserRoleAprovalServiceimpl;
import com.Portofolio.service.UserService;
import com.Portofolio.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role-aproval")
public class UserRoleAprovalController {
    @Autowired
    Mapp mapp;
    @Autowired
    UserService userService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserRoleAprovalService userRoleAprovalService;

    @PostMapping("/request-role")
    ResponseEntity requestRoleAproval(@RequestBody RequestUsersRoleDTO requestUsers, @RequestHeader("Authorization") String auth){
       System.out.println("hire");
        try{
            String token = auth.substring("Bearer ".length());
            Users users = userService.getByEmail(jwtUtils.extractUsername(token));
            System.out.println(jwtUtils.extractUsername(token));
            UserRoleAproval userRoleAproval= mapp.userAprovalToUserAproval(requestUsers);
            userRoleAproval.setUsers(users);
            userRoleAproval=userRoleAprovalService.addRequest(userRoleAproval);
            return ResponseEntity.status(HttpStatus.OK).body(userRoleAproval);

        }catch (Exception e){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);}

    }
}
