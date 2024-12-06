package com.threemtt.vmis.repository;

import com.threemtt.vmis.model.Admin;
//import com.threemtt.vmis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByEmail(String email);
    Optional<Admin> deleteByBadgeNumber(String badgeNumber);
    Optional<Admin> findByPhoneNumber(String phoneNumber);
}
