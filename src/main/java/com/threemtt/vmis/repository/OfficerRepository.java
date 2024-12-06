package com.threemtt.vmis.repository;

import com.threemtt.vmis.model.Officer;
//import com.threemtt.vmis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficerRepository extends JpaRepository<Officer, Long> {
    Optional<Officer> findByEmail(String email);
    Optional<Officer> deleteByBadgeNumber(String badgeNumber);
    Optional<Officer> findByBadgeNumber(String badgeNumber);
    Optional<Officer> findByPhoneNumber(String phoneNumber);
    Officer findByAvailabilityStatus(String availabilityStatus);
}
