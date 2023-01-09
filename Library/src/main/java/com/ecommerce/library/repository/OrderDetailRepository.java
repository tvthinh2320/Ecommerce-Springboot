package com.ecommerce.library.repository;

import com.ecommerce.library.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query("select  o from OrderDetail  o where o.order.id = :id")
    List<OrderDetail> findAllById(@Param("id") Collection<Long> id);
}
