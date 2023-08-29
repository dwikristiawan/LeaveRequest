package com.Portofolio.dto;

import lombok.*;

import java.util.Collection;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String roles;
}
