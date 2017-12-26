package com.rapid.prototype.excelsucks.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
		return dto;
	}
	
	public FoodItemDTO findOne(Long id) {
		return convert(foodRepo.findOne(id));
	}
	
	

}
