package com.rapid.prototype.excelsucks.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rapid.prototype.excelsucks.domain.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{
}
