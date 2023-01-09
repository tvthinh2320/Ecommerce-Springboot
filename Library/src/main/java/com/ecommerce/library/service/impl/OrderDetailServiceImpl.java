package com.ecommerce.library.service.impl;

import com.ecommerce.library.model.OrderDetail;
import com.ecommerce.library.repository.OrderDetailRepository;
import com.ecommerce.library.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findById(Long id) {
        List<OrderDetail> orderDetailList = orderDetailRepository.findAllById(Collections.singleton(id));
        return orderDetailList;
    }

}
