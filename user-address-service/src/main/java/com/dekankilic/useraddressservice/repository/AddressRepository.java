package com.dekankilic.useraddressservice.repository;

import com.dekankilic.useraddressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByUserId(Long userId);
}
