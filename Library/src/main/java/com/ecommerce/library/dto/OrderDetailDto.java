package com.ecommerce.library.dto;


import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailDto {

    private Long id;
    private int quantity;
    private double totalPrice;
    private double unitPrice;
    private Order order;
    private Product product;
}
