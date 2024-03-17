package com.express.controller;

import com.express.model.OrderRequest;
import com.express.model.entities.Good;
import com.express.model.entities.Order;
import com.express.model.entities.Packages;
import com.express.model.entities.Receiver;
import com.express.model.entities.Sender;
import com.express.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/")
    public List<Order> getOrders(@RequestParam(required = false) Integer id) {
        log.info("GET url: /order/api/v1/");
        return orderService.getOrders(id);
    }

    @PostMapping("/receiver")
    public Receiver postReceiver(@RequestBody Receiver receiver, Integer idOrder) {
        log.info("POST url: /order/api/v1/receiver");
        return orderService.postReceiver(receiver, idOrder);
    }

    @PostMapping("/sender")
    public Sender postSender(@RequestBody Sender sender, Integer idOrder) {
        log.info("POST url: /order/api/v1/sender");
        return orderService.postSender(sender, idOrder);
    }

    @PostMapping("/package")
    public Packages postPackages(@RequestBody Packages packages, Integer idOrder) {
        return new Packages(  );
    }

    @PostMapping("/good")
    public Good postGood(@RequestBody Good good, Integer idPackages) {
        return new Good(  );
    }
}
