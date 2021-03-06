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
        assertThat(foodItem, is("{\"id\":1,\"title\":\"Teleca corba\",\"description\":\"Mmm...\",\"price\":180,\"day\":0,\"photo_uri\":\"https://www.donesi.com/images/product/48/13248.jpg\"}"));
    }

    @Test
    public void whenGetFoodItemAsJson_thanAllOK() {
        String foodItem = restTemplate.getForObject("/menu", String.class);
        assertNotNull("food item", foodItem);
        assertThat(foodItem, is("{\"1\":[{\"id\":1,\"title\":\"Teleca corba\",\"description\":\"Mmm...\",\"price\":180,\"day\":0,\"photo_uri\":\"https://www.donesi.com/images/product/48/13248.jpg\"},{\"id\":2,\"title\":\"Corbast pasulj sa suvim mesom\",\"description\":\"Mmm...\",\"price\":350,\"day\":0,\"photo_uri\":\"https://www.donesi.com/images/product/49/13249.jpg\"},{\"id\":3,\"title\":\"Juneci gulas\",\"description\":\"Mmm...\",\"price\":430,\"day\":0,\"photo_uri\":\"https://www.donesi.com/images/product/50/13250.jpg\"},{\"id\":4,\"title\":\"Piletina sa povrcem\",\"description\":\"Mmm...\",\"price\":360,\"day\":0,\"photo_uri\":\"https://www.donesi.com/images/product/11/110611.jpg\"},{\"id\":5,\"title\":\"Pileci stapici u susamu\",\"description\":\"Mmm...\",\"price\":380,\"day\":0,\"photo_uri\":\"https://www.donesi.com/images/product/10/110610.jpg\"},{\"id\":6,\"title\":\"Svinjski vrat na zaru\",\"description\":\"Mmm...\",\"price\":430,\"day\":0,\"photo_uri\":\"https://www.donesi.com/images/product/16/124716.jpg\"},{\"id\":7,\"title\":\"Teleca corba\",\"description\":\"Mmm...\",\"price\":180,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/48/13248.jpg\"},{\"id\":8,\"title\":\"Corbast pasulj sa suvim mesom\",\"description\":\"Mmm...\",\"price\":350,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/49/13249.jpg\"},{\"id\":9,\"title\":\"Juneci gulas\",\"description\":\"Mmm...\",\"price\":430,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/50/13250.jpg\"},{\"id\":10,\"title\":\"Piletina sa povrcem\",\"description\":\"Mmm...\",\"price\":360,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/11/110611.jpg\"},{\"id\":11,\"title\":\"Pileci stapici u susamu\",\"description\":\"Mmm...\",\"price\":380,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/10/110610.jpg\"},{\"id\":12,\"title\":\"Svinjski vrat na zaru\",\"description\":\"Mmm...\",\"price\":430,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/16/124716.jpg\"},{\"id\":13,\"title\":\"Teleca corba\",\"description\":\"Mmm...\",\"price\":180,\"day\":2,\"photo_uri\":\"https://www.donesi.com/images/product/48/13248.jpg\"},{\"id\":14,\"title\":\"Corbast pasulj sa suvim mesom\",\"description\":\"Mmm...\",\"price\":350,\"day\":2,\"photo_uri\":\"https://www.donesi.com/images/product/49/13249.jpg\"},{\"id\":15,\"title\":\"Juneci gulas\",\"description\":\"Mmm...\",\"price\":430,\"day\":2,\"photo_uri\":\"https://www.donesi.com/images/product/50/13250.jpg\"},{\"id\":16,\"title\":\"Piletina sa povrcem\",\"description\":\"Mmm...\",\"price\":360,\"day\":2,\"photo_uri\":\"https://www.donesi.com/images/product/11/110611.jpg\"},{\"id\":17,\"title\":\"Pileci stapici u susamu\",\"description\":\"Mmm...\",\"price\":380,\"day\":2,\"photo_uri\":\"https://www.donesi.com/images/product/10/110610.jpg\"},{\"id\":18,\"title\":\"Svinjski vrat na zaru\",\"description\":\"Mmm...\",\"price\":430,\"day\":2,\"photo_uri\":\"https://www.donesi.com/images/product/16/124716.jpg\"},{\"id\":19,\"title\":\"Teleca corba\",\"description\":\"Mmm...\",\"price\":180,\"day\":3,\"photo_uri\":\"https://www.donesi.com/images/product/48/13248.jpg\"},{\"id\":20,\"title\":\"Corbast pasulj sa suvim mesom\",\"description\":\"Mmm...\",\"price\":350,\"day\":3,\"photo_uri\":\"https://www.donesi.com/images/product/49/13249.jpg\"},{\"id\":21,\"title\":\"Juneci gulas\",\"description\":\"Mmm...\",\"price\":430,\"day\":3,\"photo_uri\":\"https://www.donesi.com/images/product/50/13250.jpg\"},{\"id\":22,\"title\":\"Piletina sa povrcem\",\"description\":\"Mmm...\",\"price\":360,\"day\":3,\"photo_uri\":\"https://www.donesi.com/images/product/11/110611.jpg\"},{\"id\":23,\"title\":\"Pileci stapici u susamu\",\"description\":\"Mmm...\",\"price\":380,\"day\":3,\"photo_uri\":\"https://www.donesi.com/images/product/10/110610.jpg\"},{\"id\":24,\"title\":\"Svinjski vrat na zaru\",\"description\":\"Mmm...\",\"price\":430,\"day\":3,\"photo_uri\":\"https://www.donesi.com/images/product/16/124716.jpg\"},{\"id\":25,\"title\":\"Teleca corba\",\"description\":\"Mmm...\",\"price\":180,\"day\":4,\"photo_uri\":\"https://www.donesi.com/images/product/48/13248.jpg\"},{\"id\":26,\"title\":\"Corbast pasulj sa suvim mesom\",\"description\":\"Mmm...\",\"price\":350,\"day\":4,\"photo_uri\":\"https://www.donesi.com/images/product/49/13249.jpg\"},{\"id\":27,\"title\":\"Juneci gulas\",\"description\":\"Mmm...\",\"price\":430,\"day\":4,\"photo_uri\":\"https://www.donesi.com/images/product/50/13250.jpg\"},{\"id\":28,\"title\":\"Piletina sa povrcem\",\"description\":\"Mmm...\",\"price\":360,\"day\":4,\"photo_uri\":\"https://www.donesi.com/images/product/11/110611.jpg\"},{\"id\":29,\"title\":\"Pileci stapici u susamu\",\"description\":\"Mmm...\",\"price\":380,\"day\":4,\"photo_uri\":\"https://www.donesi.com/images/product/10/110610.jpg\"},{\"id\":30,\"title\":\"Svinjski vrat na zaru\",\"description\":\"Mmm...\",\"price\":430,\"day\":4,\"photo_uri\":\"https://www.donesi.com/images/product/16/124716.jpg\"}]}"));
    }

    @Test
    public void whenGetFoodItemWithTheGivenDay_thanAllOK() {
        String foodItem = restTemplate.getForObject("/menu/day/1", String.class);
        assertNotNull("food item", foodItem);
        assertThat(foodItem, is("{\"1\":[{\"id\":7,\"title\":\"Teleca corba\",\"description\":\"Mmm...\",\"price\":180,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/48/13248.jpg\"},{\"id\":8,\"title\":\"Corbast pasulj sa suvim mesom\",\"description\":\"Mmm...\",\"price\":350,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/49/13249.jpg\"},{\"id\":9,\"title\":\"Juneci gulas\",\"description\":\"Mmm...\",\"price\":430,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/50/13250.jpg\"},{\"id\":10,\"title\":\"Piletina sa povrcem\",\"description\":\"Mmm...\",\"price\":360,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/11/110611.jpg\"},{\"id\":11,\"title\":\"Pileci stapici u susamu\",\"description\":\"Mmm...\",\"price\":380,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/10/110610.jpg\"},{\"id\":12,\"title\":\"Svinjski vrat na zaru\",\"description\":\"Mmm...\",\"price\":430,\"day\":1,\"photo_uri\":\"https://www.donesi.com/images/product/16/124716.jpg\"}]}"));
    }

}