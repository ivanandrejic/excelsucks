package com.rapid.prototype.excelsucks.service;

import com.rapid.prototype.excelsucks.domain.Order;
import com.rapid.prototype.excelsucks.web.dto.OrderDTO;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {


    @Transactional
    Order create(OrderDTO dto);
}
