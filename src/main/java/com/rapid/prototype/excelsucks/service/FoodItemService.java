package com.rapid.prototype.excelsucks.service;

import java.util.List;
import java.util.Map;

import com.rapid.prototype.excelsucks.web.dto.FoodItemDTO;

public interface FoodItemService {

	public List<FoodItemDTO> findAll();
	
	public Map<Integer, List<FoodItemDTO>> findAllMap();
	
	public List<FoodItemDTO> findByDay(Integer day);
	
	public FoodItemDTO findOne(Long id);
	
}
