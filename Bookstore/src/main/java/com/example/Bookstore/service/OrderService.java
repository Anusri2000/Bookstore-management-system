package com.example.Bookstore.service;

import com.example.Bookstore.dto.OrderRequest;
import com.example.Bookstore.enums.OrderStatus;
import com.example.Bookstore.model.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(OrderRequest request);

    List<Order> getAllOrders();

    Order getOrderById(String id);

    Order updateOrderStatus(
            String id,
            OrderStatus status
    );
}