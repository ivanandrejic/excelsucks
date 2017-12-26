package com.rapid.prototype.excelsucks.service;

import java.util.stream.Collectors;

import com.rapid.prototype.excelsucks.domain.Order;
import com.rapid.prototype.excelsucks.domain.OrderItem;
import com.rapid.prototype.excelsucks.repo.FoodItemRepository;
import com.rapid.prototype.excelsucks.repo.OrderItemRepository;
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
}
