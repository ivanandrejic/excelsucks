package com.rapid.prototype.excelsucks.repo;

import java.util.List;

import com.rapid.prototype.excelsucks.domain.OrderItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem, Long> {

    @Query("select oi from OrderItem oi join oi.foodItems fi where fi.day = :day")
    List<OrderItem> findByDay(@Param("day") Integer day);
}
