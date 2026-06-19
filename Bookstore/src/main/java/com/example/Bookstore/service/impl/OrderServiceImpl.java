package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.OrderRequest;
import com.example.Bookstore.enums.OrderStatus;
import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.Order;
import com.example.Bookstore.model.OrderItem;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.OrderRepository;
import com.example.Bookstore.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    // Constructor Injection
    public OrderServiceImpl(
            OrderRepository orderRepository,
            BookRepository bookRepository
    ) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Order placeOrder(OrderRequest request) {

        Book book = bookRepository.findById(
                request.getBookId()
        ).orElseThrow(
                () -> new RuntimeException("Book not found")
        );

        if (book.getStockQuantity() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }

        double totalPrice =
                book.getPrice() * request.getQuantity();

        book.setStockQuantity(
                book.getStockQuantity()
                        - request.getQuantity()
        );

        bookRepository.save(book);

        OrderItem item = new OrderItem(
                book.getId(),
                request.getQuantity(),
                book.getPrice()
        );

        Order order = new Order();

        order.setCustomerName(
                request.getCustomerName()
        );

        order.setCustomerEmail(
                request.getCustomerEmail()
        );

        order.setItems(
                Collections.singletonList(item)
        );

        order.setTotalPrice(totalPrice);

        order.setStatus(OrderStatus.PENDING);

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(String id) {

        return orderRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Order not found"
                        )
                );
    }

    @Override
    public Order updateOrderStatus(
            String id,
            OrderStatus status
    ) {

        Order order = getOrderById(id);

        order.setStatus(status);

        return orderRepository.save(order);
    }
}