package org.unlogged.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unlogged.demo.models.CustomerProfile;

public interface CustomerProfileRepo extends JpaRepository<CustomerProfile, Long> {
    @Query(value = "SELECT * FROM customerprofile u WHERE u.customerid = :customerid", nativeQuery = true)
    public CustomerProfile getByCustomerId(long customerid);
}
