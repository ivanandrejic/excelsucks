package com.rapid.prototype.excelsucks.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rapid.prototype.excelsucks.domain.Order;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{
}
