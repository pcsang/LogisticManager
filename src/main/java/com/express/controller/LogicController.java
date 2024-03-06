package com.express.controller;

import com.express.model.Order;
import com.express.model.Package;
import com.express.model.request.OrderRequest;
import com.express.model.response.OrderInfo;
import com.express.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/logic/v1")
public class LogicController {
    private final OrderService orderService;

    /**
     * Constructor of LogicController
     * @param orderService orderService
     */
    @Autowired
    public LogicController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public Set<Order> getOrders() {
        Set<Order> orders = new HashSet<>();
        return orders;
    }

    @GetMapping("/orders")
    public Order getOrderById(@RequestParam String id) {
        return new Order();
    }

    @PostMapping("/orders")
    public OrderInfo postOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.postOrder(orderRequest);
    }

    @PostMapping("/orders")
    public Order updateOrder(@RequestBody Order order, @RequestParam String id) {
        return new Order();
    }

    @DeleteMapping("/orders")
    public void deleteOrder(@RequestParam String id) {

    }

    @PostMapping("/packages")
    public Order postPackage(@RequestBody Package packages, @RequestParam String idOrder) {
        //post data into package and update related to key of Order
        return new Order();
    }

    @DeleteMapping("/packages")
    public void deletePackage(@RequestParam String id) {}

    @GetMapping("/search")
    public void search(@RequestParam String id) {
       // search by Id Order to get info of package
    }
}
