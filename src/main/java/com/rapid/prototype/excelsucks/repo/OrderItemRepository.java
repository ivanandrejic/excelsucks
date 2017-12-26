package com.rapid.prototype.excelsucks.repo;

import com.rapid.prototype.excelsucks.domain.OrderItem;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem, Long> {
}
