package com.rapid.prototype.excelsucks.web;

import com.rapid.prototype.excelsucks.web.dto.FoodItemBuilder;
import com.rapid.prototype.excelsucks.web.dto.FoodItemDTO;
import com.rapid.prototype.excelsucks.web.dto.SummaryFoodList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@CrossOrigin
@RequestMapping("/menu")
@RestController
public class MenuController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET )
    public Map<Long, SummaryFoodList> getFoodList() {
        List<FoodItemDTO> foodItemDTOS = new ArrayList<>();
        foodItemDTOS.add(new FoodItemBuilder().createFoodItemDTO());
        SummaryFoodList summaryFoodList = new SummaryFoodList();
        summaryFoodList.setFoodItems(foodItemDTOS);
        Map<Long, SummaryFoodList>  mFoodList = new HashMap<>();
        mFoodList.put(1l, summaryFoodList);
        return mFoodList;
    }

    @RequestMapping(value = {"/id/{foodItemID}"}, method = RequestMethod.GET )
    public FoodItemDTO getFoodItem(@PathVariable Long foodItemID) {
        return new FoodItemBuilder().createFoodItemDTO();
    }

}
