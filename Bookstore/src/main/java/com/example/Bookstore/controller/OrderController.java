package com.example.Bookstore.controller;

import com.example.Bookstore.dto.OrderRequest;
import com.example.Bookstore.enums.OrderStatus;
import com.example.Bookstore.model.Order;
import com.example.Bookstore.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    // Constructor Injection
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(
            @RequestBody OrderRequest request
    ) {
        return orderService.placeOrder(request);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(
            @PathVariable String id
    ) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(
            @PathVariable String id,
            @RequestParam OrderStatus status
    ) {
        return orderService.updateOrderStatus(
                id,
                status
        );
    }
}