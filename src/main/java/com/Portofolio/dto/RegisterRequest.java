package com.Portofolio.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}
