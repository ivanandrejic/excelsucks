package com.rapid.prototype.excelsucks.web;

import com.rapid.prototype.excelsucks.ExcelsucksApplication;
import com.rapid.prototype.excelsucks.web.dto.SummaryFoodList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExcelsucksApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void whenGetFoodItem_thanAllOK() {
        Map<Long, SummaryFoodList> foodItem = restTemplate.getForObject("/1", Map.class);
        assertNotNull("food item", foodItem);
    }

    @Test
    public void whenGetFoodList_thanAllOK() {
        SummaryFoodList foodList = restTemplate.getForObject("/", SummaryFoodList.class);
        assertNotNull("food list is empty", foodList);
    }

}