package com.ecommerce.admin.controller;


import com.ecommerce.library.model.Customer;
import com.ecommerce.library.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customersList")
    public String customers(Model model, Principal principal) {
        if(principal == null) {
            return "redirect:/login";
        }
        List<Customer> customers = customerService.findAll();
        model.addAttribute("title", "Customer List");
        model.addAttribute("size", customers.size());
        model.addAttribute("customers", customers);
        return "customersList";
    }


}
