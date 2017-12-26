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
public class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenGetOrderByName_thanOK() {
        String foodItem = restTemplate.getForObject("/order?name=slavisa&day=1", String.class);
        assertNotNull("food item", foodItem);
        assertThat(foodItem, is("{\"day\":\"0\",\"name\":\"name\",\"orderItems\":null}"));
    }

    @Test
    public void whenPostOrder_thanOK() {
        String foodItem = restTemplate.postForObject("/order?name=slavisa&day=1&foodList=1,2,3", "", String.class);
        assertNotNull("food item", foodItem);

        assertThat(foodItem, is("{\"day\":\"1\",\"name\":\"slavisa\",\"orderItems\":[{\"id\":null,\"name\":null,\"foodItems\":[{\"id\":1,\"title\":\"naslov\",\"description\":\"opis\",\"price\":10,\"day\":null,\"photo_uri\":\"photoURI\"},{\"id\":2,\"title\":\"naslov\",\"description\":\"opis\",\"price\":10,\"day\":null,\"photo_uri\":\"photoURI\"},{\"id\":3,\"title\":\"naslov\",\"description\":\"opis\",\"price\":10,\"day\":null,\"photo_uri\":\"photoURI\"}]}]}"));
    }

    @Test
    public void whenWeeklyReport_thanOK() {
        restTemplate.postForObject("/order?name=slavisa&day=1&foodList=1,2,3", "", String.class);
        String foodItem = restTemplate.getForObject("/order/weekly", String.class);
        assertNotNull("food item", foodItem);

        assertThat(foodItem, is("{\"orders\":[{\"name\":\"Slavisa\",\"sum\":12.339999999999999857891452847979962825775146484375}],\"total_sum\":1234.55999999999994543031789362430572509765625}"));
    }

}