package com.rapid.prototype.excelsucks.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.rapid.prototype.excelsucks.domain.Order;
import com.rapid.prototype.excelsucks.domain.OrderItem;
import com.rapid.prototype.excelsucks.repo.FoodItemRepository;
import com.rapid.prototype.excelsucks.repo.OrderItemRepository;
import com.rapid.prototype.excelsucks.web.dto.OrderDailyDTO;
import com.rapid.prototype.excelsucks.web.dto.OrderItemDTO;

import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final FoodItemRepository foodItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository, FoodItemRepository foodItemRepository) {
        this.orderItemRepository = orderItemRepository;
        this.foodItemRepository = foodItemRepository;
    }

    public OrderItem create(Order order, OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(order.getId());
        orderItem.setName(orderItemDTO.getName());
        orderItem.setFoodItems(foodItemRepository.findByIds(orderItemDTO.getFoodItems().stream().map(fi -> fi.getId()).collect(Collectors.toList())));
        return orderItemRepository.save(orderItem);
    }

    public List<OrderDailyDTO> getDailyOrders(Integer day) {
        List<OrderItem> orderItems = orderItemRepository.findByDay(day);
        Map<String, OrderDailyDTO> data = new HashMap<>();

        for (OrderItem orderItem : orderItems) {

            orderItem.getFoodItems().forEach(fi ->

                                             {
                                                 OrderDailyDTO list = new OrderDailyDTO();
                                                 list.setFoodName(fi.getTitle());
                                                 if (data.containsKey(fi.getTitle())) {
                                                     list = data.get(fi.getTitle());
                                                 } else {
                                                     data.put(fi.getTitle(), list);
                                                 }

                                                 list.setCount(list.getCount() + 1);
                                                 list.getNames().add(orderItem.getName());
                                             });
        }
        return new ArrayList<>(data.values());
    }
}
