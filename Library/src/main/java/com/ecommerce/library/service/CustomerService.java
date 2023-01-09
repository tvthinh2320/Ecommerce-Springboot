package com.ecommerce.library.service;

import com.ecommerce.library.dto.CustomerDto;
import com.ecommerce.library.model.Customer;

import java.util.List;


public interface CustomerService {
    //Admin
    List<Customer> findAll();






    //Customer
    CustomerDto save(CustomerDto customerDto);

    Customer findByUserName(String username);

    Customer saveInfor(Customer customer);
}
