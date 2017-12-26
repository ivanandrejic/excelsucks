package com.rapid.prototype.excelsucks.web;

import com.rapid.prototype.excelsucks.ExcelsucksApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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
        String foodItem = restTemplate.getForObject("/menu/id/1", String.class);
        assertNotNull("food item", foodItem);
        assertThat(foodItem, is("{\"id\":1,\"title\":\"naslov\",\"description\":\"opis\",\"price\":10,\"photo_uri\":\"photoURI\"}"));
    }

    @Test
    public void whenGetFoodItemAsJson_thanAllOK() {
        String foodItem = restTemplate.getForObject("/menu", String.class);
        assertNotNull("food item", foodItem);
        assertThat(foodItem, is("{\"1\":{\"foodItems\":[{\"id\":1,\"title\":\"naslov\",\"description\":\"opis\",\"price\":10,\"photo_uri\":\"photoURI\"}]}}"));
    }

    @Test
    public void whenGetFoodItemWithTheGivenDay_thanAllOK() {
        String foodItem = restTemplate.getForObject("/menu/day/1", String.class);
        assertNotNull("food item", foodItem);
        assertThat(foodItem, is("{\"1\":{\"foodItems\":[{\"id\":1,\"title\":\"naslov\",\"description\":\"opis\",\"price\":10,\"photo_uri\":\"photoURI\"}]}}"));
    }

}