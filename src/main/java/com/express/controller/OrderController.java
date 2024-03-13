package com.express.controller;

import com.express.model.OrderRequest;
import com.express.model.entities.Order;
import com.express.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/api/v1")
@Slf4j
public class OrderController {
    private final OrderService orderService;

    /**
     * Constructor of OrderService
     * @param orderService orderService
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/register")
    public Order RegisterOrder(@RequestBody OrderRequest order) {
        log.info("POST url: /order/api/v1/register");
        return orderService.postOrder(order);
    }
}
