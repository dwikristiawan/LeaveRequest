package com.Portofolio.repository;

import com.Portofolio.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {
    public Roles getByName(String name);
}
