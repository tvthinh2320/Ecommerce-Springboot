package com.ecommerce.library.service;

import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.ShoppingCart;

import java.util.List;

public interface OrderService {
//admin
    List<Order> findAll();


    void acceptById(Long id);

    void declineById(Long id);


    //customer
    void saveOrder(ShoppingCart cart);

    void acceptOrder(Long id);

    void deleteOrder(Long id);


    void shippedOrder(Long id);
}
