package com.Portofolio.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class ProfileDTO {
    private String username;
    private String email;
    private String telpon;
    private String gender;
    private String birth;
    private String address;
}
