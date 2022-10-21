package com.company.customerapi.repository;

import com.company.customerapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    // Find a customer record by id.
    List<Customer> findById (int customer_id);
    // Find customer records by state.
    List<Customer> findByState(String state);
}
