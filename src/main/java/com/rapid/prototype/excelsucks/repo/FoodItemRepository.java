package com.rapid.prototype.excelsucks.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rapid.prototype.excelsucks.domain.FoodItem;

@Repository
public interface FoodItemRepository extends PagingAndSortingRepository<FoodItem, Long>{

    @Query("select f from FoodItem f where f.id in (:ids)")
    List<FoodItem> findByIds(@Param("ids") List<Long> ids);

	public List<FoodItem> findByDay(@Param("day")Integer day);

}
