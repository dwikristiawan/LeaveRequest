package com.Portofolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    @JsonIgnore
    @OneToMany(mappedBy = "roles",cascade = CascadeType.ALL,orphanRemoval = true)
    List<UserRole> userRoles;
}
