package com.company.customerapi.controller;

import com.company.customerapi.model.Customer;
import com.company.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController
{
    @Autowired
    CustomerRepository repo;

    //    Create a new customer record.
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody Customer customer)
    {
        repo.save(customer);
    }
    //    Update an existing customer record.
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer)
    {
        repo.save(customer);
    }
    //    Delete an existing customer record.
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id)
    {
        repo.deleteById(id);
    }
}
