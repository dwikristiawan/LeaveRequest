package com.Portofolio.repository;

import com.Portofolio.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    public boolean existsByEmail(String email);


    public Users findByEmail(String email);


    Users findByUsername(String name);
}
