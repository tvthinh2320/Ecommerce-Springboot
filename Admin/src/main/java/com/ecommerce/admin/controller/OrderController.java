package com.ecommerce.admin.controller;


import com.ecommerce.library.model.Order;
import com.ecommerce.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String order(Principal principal, Model model) {
        if(principal == null) {
            return "redirect:/login";
        }
        List<Order> orderList = orderService.findAll();
        model.addAttribute("title", "Manage Orders");
        model.addAttribute("orders", orderList);
        model.addAttribute("size", orderList.size());
        return "orders";

    }

    @RequestMapping(value = "/accept-order/{id}" , method =  {RequestMethod.PUT, RequestMethod.GET})
    public String acceptOrder(@PathVariable("id") Long id, RedirectAttributes attributes){
        try {
            orderService.acceptById(id);
            attributes.addFlashAttribute("success","The orders has been Accepted");

        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("error","The orders status has not been changed");

        }
        return "redirect:/orders";
    }


    @RequestMapping(value = "/decline-order/{id}" , method =  {RequestMethod.PUT, RequestMethod.GET})
    public String declineOrder(@PathVariable("id") Long id, RedirectAttributes attributes){
        try {
            orderService.declineById(id);
            attributes.addFlashAttribute("success","The orders has been Declined");

        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("error","The orders status has not been changed");

        }
        return "redirect:/orders";
    }


    @RequestMapping(value = "/shipped-order{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String shippedOrder(@PathVariable("id")Long id, RedirectAttributes attributes) {
        try {
            orderService.shippedOrder(id);
            attributes.addFlashAttribute("success","The order has been shipped");

        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("error","There is an error!");
        }
        return "redirect:/orders";
    }



}
