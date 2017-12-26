package com.rapid.prototype.excelsucks.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rapid.prototype.excelsucks.domain.FoodItem;

@Repository
public interface FoodItemRepository extends PagingAndSortingRepository<FoodItem, Long>{
}
