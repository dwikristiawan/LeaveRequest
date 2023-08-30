package com.Portofolio.repository;

import com.Portofolio.model.UserRoleAproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleAprovalRepository extends JpaRepository<UserRoleAproval,Integer> {
}
