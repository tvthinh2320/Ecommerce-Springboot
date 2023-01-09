package com.ecommerce.library.service;

import com.ecommerce.library.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetail> findById(Long id);

//    List<OrderDetail> orderDetailList(Long id);
}
