package com.Portofolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private String position;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
