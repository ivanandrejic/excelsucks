package com.rapid.prototype.excelsucks.web;

import com.rapid.prototype.excelsucks.service.FoodItemService;
import com.rapid.prototype.excelsucks.web.dto.FoodItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.rapid.prototype.excelsucks.web.dto.FoodItemBuilder;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@CrossOrigin
@RequestMapping("/menu")
@RestController
public class MenuController {
	
	@Autowired
	FoodItemService foodService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET )
    public Map<Long, List<FoodItemDTO>> getFoodList() {
        List<FoodItemDTO> foodItemDTOS = foodService.findAll();
        Map<Long, List<FoodItemDTO>>  mFoodList = new HashMap<>();
        mFoodList.put(1l, foodItemDTOS);
        return mFoodList;
    }

    @RequestMapping(value = {"/day/{day}"}, method = RequestMethod.GET )
    public Map<Long, List<FoodItemDTO>> getFoodList(@PathVariable Integer day) {
        List<FoodItemDTO> foodItemDTOS = foodService.findByDay(day);
        Map<Long, List<FoodItemDTO>>  mFoodList = new HashMap<>();
        mFoodList.put(1l, foodItemDTOS);
        return mFoodList;
    }

    @RequestMapping(value = {"/id/{foodItemID}"}, method = RequestMethod.GET )
    public FoodItemDTO getFoodItem(@PathVariable Long foodItemID) {
        return foodService.findOne(foodItemID);
    }

}
