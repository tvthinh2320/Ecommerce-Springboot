package com.ecommerce.library.repository;

import com.ecommerce.library.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Admin
    List<Customer> findAll();



    //Customer
    Customer findByUsername (String username);


}
