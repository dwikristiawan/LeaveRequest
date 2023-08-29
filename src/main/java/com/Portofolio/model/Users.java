package com.Portofolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private  String telpon;
    private String gender;
    @Temporal(TemporalType.DATE)
    private Date birth;
    private String address;
    private Boolean complated;
    @ManyToOne
    @JoinColumn(name="aproval_status")
    private StatusAproval status;
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole role;
}
