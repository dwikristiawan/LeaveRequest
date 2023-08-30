package com.Portofolio.repository;

import com.Portofolio.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {
    @Modifying
    @Query(value = "SELECT * FROM manager a JOIN users b ON a.user.id=b.id where b.username=:username",nativeQuery = true)

    Manager getByName(@Param("username") String name);
}
