package com.rapid.prototype.excelsucks.repo;

import com.rapid.prototype.excelsucks.domain.FoodItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FoodItemRepository extends PagingAndSortingRepository<FoodItem, Long>{


	public List<FoodItem> findByDay(@Param("day")Integer day);


    @Query("select f from FoodItem f where f.id in (:ids)")
    List<FoodItem> findByIds(@Param("ids") List<Long> ids);
}
