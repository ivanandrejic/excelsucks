package com.rapid.prototype.excelsucks.web;

import com.rapid.prototype.excelsucks.ExcelsucksApplication;
import com.rapid.prototype.excelsucks.web.dto.FoodItemDTO;
import com.rapid.prototype.excelsucks.web.dto.SummaryFoodList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExcelsucksApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void whenGetFoodItem_thanAllOK() {
        FoodItemDTO foodItem = restTemplate.getForObject("/1", FoodItemDTO.class);
        assertNotNull("food item", foodItem);
    }

    @Test
    public void whenGetFoodList_thanAllOK() {
        SummaryFoodList foodList = restTemplate.getForObject("/", SummaryFoodList.class);
        assertNotNull("food list is empty", foodList);
    }

}