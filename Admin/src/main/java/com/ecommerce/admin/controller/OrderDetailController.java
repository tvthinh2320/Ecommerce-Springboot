package com.ecommerce.admin.controller;


import com.ecommerce.library.model.OrderDetail;
import com.ecommerce.library.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;


    @GetMapping("/orderDetail/{id}")
    public String orderDetail(@PathVariable("id") Long id, Model model, Principal principal) {
        if(principal == null) {
            return "redirect:/login";
        }
        List<OrderDetail> orderDetailList = orderDetailService.findById(id);
        model.addAttribute("details", orderDetailList);
        model.addAttribute("size", orderDetailList.size());
        model.addAttribute("title", "Manage Order Details");
        return "order-detail";
    }
}
