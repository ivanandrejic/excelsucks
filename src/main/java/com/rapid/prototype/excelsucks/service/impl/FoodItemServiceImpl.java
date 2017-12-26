package com.rapid.prototype.excelsucks.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.prototype.excelsucks.domain.FoodItem;
import com.rapid.prototype.excelsucks.repo.FoodItemRepository;
import com.rapid.prototype.excelsucks.service.FoodItemService;
import com.rapid.prototype.excelsucks.web.dto.FoodItemDTO;

@Service
public class FoodItemServiceImpl implements FoodItemService {

	@Autowired
	FoodItemRepository foodRepo;
	
	@Override
	public List<FoodItemDTO> findAll() {
		
		List<FoodItemDTO> result = new ArrayList<FoodItemDTO>();
		for(FoodItem item: foodRepo.findAll()) {
			FoodItemDTO dto = convert(item);
			result.add(dto);
		}
		return result;
	}
	
	@Override
	public Map<Integer, List<FoodItemDTO>> findAllMap() {
		
		Map<Integer, List<FoodItemDTO>> result = new LinkedHashMap<Integer, List<FoodItemDTO>>();
		for(FoodItem item: foodRepo.findAll()) {
			FoodItemDTO dto = convert(item);
			if (result.containsKey(item.getDay())) {
				result.get(item.getDay()).add(dto);
			} else {
				List<FoodItemDTO> list = new ArrayList<>();
				list.add(dto);
				result.put(item.getDay(), list);
			}
		}
		return result;
	}
	
	public FoodItemDTO findOne(Long id) {
		return convert(foodRepo.findOne(id));
	}
	
	public List<FoodItemDTO> findByDay(Integer day) {
		List<FoodItemDTO> result = new ArrayList<FoodItemDTO>();
		for(FoodItem item: foodRepo.findByDay(day)) {
			result.add(convert(item));
		}
		return result;
	}
	
	private FoodItemDTO convert(FoodItem item) {
		FoodItemDTO dto = new FoodItemDTO();
		dto.setDescription(item.getDescription());
		dto.setId(item.getId());
		dto.setPhotoURI(item.getPhotoUri());
		dto.setPrice(new BigDecimal(item.getPrice()));
		dto.setTitle(item.getTitle());
		dto.setDay(item.getDay());
		return dto;
	}
	

}
