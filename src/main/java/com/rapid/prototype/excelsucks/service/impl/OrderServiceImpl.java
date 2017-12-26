package com.rapid.prototype.excelsucks.service.impl;

import com.rapid.prototype.excelsucks.domain.Order;
import com.rapid.prototype.excelsucks.repo.OrderRepository;
import com.rapid.prototype.excelsucks.service.OrderItemService;
import com.rapid.prototype.excelsucks.service.OrderService;
import com.rapid.prototype.excelsucks.web.dto.OrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemService orderItemService) {
        this.orderRepository = orderRepository;
        this.orderItemService = orderItemService;
    }


    @Override
    @Transactional
    public Order create(final OrderDTO dto) {
        Order order = new Order();
        orderRepository.save(order);
        order.setOrderItems(dto.getOrderItems().stream().map(orderItem ->
            orderItemService.create(order, orderItem)).collect(Collectors.toSet()));
        return orderRepository.save(order);
    }


}
