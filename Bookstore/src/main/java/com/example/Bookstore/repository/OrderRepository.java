package com.example.Bookstore.repository;

import com.example.Bookstore.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository
        extends MongoRepository<Order, String> {
}