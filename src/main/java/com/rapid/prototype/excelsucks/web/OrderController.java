package com.rapid.prototype.excelsucks.web;

import com.rapid.prototype.excelsucks.web.dto.FoodItemDTO;
import com.rapid.prototype.excelsucks.web.dto.OrderDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @RequestMapping(value = {"/name"}, method = RequestMethod.POST)
    public OrderDTO postOrder(@RequestBody List<FoodItemDTO> foodList) {
        return new OrderDTO();
    }

    @RequestMapping(value = {"/name"}, method = RequestMethod.PATCH)
    public OrderDTO patchOrder(@RequestBody List<FoodItemDTO> foodList) {
        return new OrderDTO();
    }

    @RequestMapping(value = {"/name"}, method = RequestMethod.GET)
    public OrderDTO getOrder(@RequestParam String day) {
        return new OrderDTO();
    }

    @RequestMapping(value = {"/name"}, method = RequestMethod.GET)
    public List<OrderDTO> getAllOrders(@RequestParam String day) {
        return new ArrayList<OrderDTO>();
    }
}
