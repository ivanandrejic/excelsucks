package com.rapid.prototype.excelsucks.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rapid.prototype.excelsucks.domain.FoodItem;

public interface FoodItemRepository extends PagingAndSortingRepository<FoodItem, Long>{
}
