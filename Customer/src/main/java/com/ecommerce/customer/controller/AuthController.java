package com.ecommerce.customer.controller;

import com.ecommerce.library.dto.CustomerDto;
import com.ecommerce.library.model.Customer;
import com.ecommerce.library.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "register";
    }

    @PostMapping("/do-register")
    public String processRegister(@Valid @ModelAttribute("customerDto") CustomerDto customerDto,
                                  BindingResult result,
                                  Model model
                                   ){
        try {
            if(result.hasErrors()) {
                model.addAttribute("customerDto",customerDto);
                return "register";
            }
            Customer customer = customerService.findByUserName(customerDto.getUsername());
            if(customer != null) {
                model.addAttribute("username", "Username has been registered");
                model.addAttribute("customerDto", customerDto);
                return "register";
            }
            if(customerDto.getPassword().equals(customerDto.getRepeatPassword())) {
                customerDto.setPassword(passwordEncoder.encode(customerDto.getPassword()));
                customerService.save(customerDto);
                model.addAttribute("success","Register successfully");

            } else {
                model.addAttribute("password", "Password is not the same");
                model.addAttribute("customerDto", customerDto);

            }
            return "register";

        } catch (Exception e) {
            model.addAttribute("error","Server has ran into some problems");
            model.addAttribute("customerDto", customerDto);

            e.printStackTrace();
        }
        return "register";
    }
}
