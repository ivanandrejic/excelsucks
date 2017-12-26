package com.rapid.prototype.excelsucks.web;

import com.rapid.prototype.excelsucks.domain.Order;
import com.rapid.prototype.excelsucks.service.OrderItemService;
import com.rapid.prototype.excelsucks.service.OrderService;
import com.rapid.prototype.excelsucks.web.dto.FoodItemBuilder;
import com.rapid.prototype.excelsucks.web.dto.FoodItemDTO;
import com.rapid.prototype.excelsucks.web.dto.OrderBuilder;
import com.rapid.prototype.excelsucks.web.dto.OrderDTO;
import com.rapid.prototype.excelsucks.web.dto.OrderDailyDTO;
import com.rapid.prototype.excelsucks.web.dto.OrderItemDTO;
import com.rapid.prototype.excelsucks.web.dto.OrderItemDTOBuilder;
import com.rapid.prototype.excelsucks.web.dto.WeeklyOrdersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@CrossOrigin
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public OrderDTO getOrder(@RequestParam String name, @RequestParam String day) {
        return new OrderBuilder().createOrderDTO();
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public OrderDTO postOrder(@RequestParam String name, @RequestParam String day, @RequestParam Long[] foodList) {
        List<OrderItemDTO> orderItems = new ArrayList<>();
        List<FoodItemDTO> listFoodItems = Arrays.stream(foodList).map(foodListID -> new FoodItemBuilder().setId(foodListID).createFoodItemDTO()).collect(Collectors.toList());
        orderItems.add(new OrderItemDTOBuilder().setFoodItems(listFoodItems).createOrderItemDTO());
        OrderDTO order = new OrderBuilder().setDay(day).setName(name).setOrderList(orderItems).createOrderDTO();

        Order orderCreated = orderService.create(order);
        return order;
    }

    @RequestMapping(value = {"/name"}, method = RequestMethod.POST)
    public OrderDTO postOrder(@RequestBody List<FoodItemDTO> foodList) {
        return new OrderBuilder().createOrderDTO();
    }

    @RequestMapping(value = {"/name"}, method = RequestMethod.PATCH)
    public OrderDTO patchOrder(@RequestBody List<FoodItemDTO> foodList) {
        return new OrderBuilder().createOrderDTO();
    }

    @RequestMapping(value = {"/daily/{day}"}, method = RequestMethod.GET)
    public List<OrderDailyDTO> getDailyOrders(@PathVariable Integer day) {
        return orderItemService.getDailyOrders(day);
    }

    @RequestMapping(value = {"/weekly"}, method = RequestMethod.GET)
    public WeeklyOrdersDTO getWeeklyOrders() {
        return orderItemService.fetchWeeklyReport();
    }

}
