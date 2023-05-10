package com.hkemal.simpleinsuraceapp.repository;

import com.hkemal.simpleinsuraceapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
