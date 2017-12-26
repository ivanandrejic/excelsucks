package com.rapid.prototype.excelsucks.service;

import com.rapid.prototype.excelsucks.domain.FoodItem;
import com.rapid.prototype.excelsucks.domain.Order;
import com.rapid.prototype.excelsucks.domain.OrderItem;
import com.rapid.prototype.excelsucks.repo.FoodItemRepository;
import com.rapid.prototype.excelsucks.repo.OrderItemRepository;
import com.rapid.prototype.excelsucks.web.dto.OrderDailyDTO;
import com.rapid.prototype.excelsucks.web.dto.OrderItemDTO;
import com.rapid.prototype.excelsucks.web.dto.WeeklyOrderDTO;
import com.rapid.prototype.excelsucks.web.dto.WeeklyOrdersDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

    public WeeklyOrdersDTO fetchWeeklyReport() {
        Iterable<OrderItem> items = orderItemRepository.findAll();

        Map<String, List<FoodItem>> foodItemsPerName = new HashMap<>();
        for (OrderItem item : items) {
            if (foodItemsPerName.get(item.getName()) != null) {
                foodItemsPerName.get(item.getName()).addAll(item.getFoodItems());
            } else {
                foodItemsPerName.put(item.getName(), item.getFoodItems());
            }
        }

        Map<String, BigDecimal> foodPrice = new HashMap<>();
        for (String person : foodItemsPerName.keySet()) {
            foodPrice.put(person, totalPricePerPerson(foodItemsPerName.get(person)));
        }

        List<WeeklyOrderDTO> weeklyOrderDTOS = new ArrayList<>();

        for (String person : foodPrice.keySet()) {
            WeeklyOrderDTO order = new WeeklyOrderDTO(person, foodPrice.get(person));
            weeklyOrderDTOS.add(order);
        }
        BigDecimal totalSum = weeklyOrderDTOS.stream().map(w -> w.getSum())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new WeeklyOrdersDTO(totalSum, weeklyOrderDTOS);
    }

    private BigDecimal totalPricePerPerson(List<FoodItem> foodItems) {
        double sum = foodItems.stream().map(FoodItem::getPrice).mapToDouble(Double::doubleValue).sum();
        return new BigDecimal(sum);
    }


}
