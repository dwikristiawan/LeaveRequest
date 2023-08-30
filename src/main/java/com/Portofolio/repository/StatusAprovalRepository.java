package com.Portofolio.repository;

import com.Portofolio.model.StatusAproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusAprovalRepository extends JpaRepository<StatusAproval, Integer> {


    StatusAproval getByStatus(String status);
}
