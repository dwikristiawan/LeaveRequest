package com.Portofolio.config.security;

import com.Portofolio.dto.UsersDTO;
import com.Portofolio.model.Users;
import com.Portofolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserService usersService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users=usersService.getByEmail(email);
        if (users==null){
            throw new UsernameNotFoundException("user not found");
        }
        return new User(users.getEmail(),users.getPassword(),new ArrayList<>());


    }
}
