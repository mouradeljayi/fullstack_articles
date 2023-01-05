package com.ecommerce.ecommerce.products.controllers;

import com.ecommerce.ecommerce.products.model.Order;
import com.ecommerce.ecommerce.products.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody List<Long> articlesIds) {
        return ResponseEntity.ok(orderService.createOrder(articlesIds));
    }

    @PutMapping("/{id}/products/{productId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @PathVariable Long articleId, @RequestParam boolean add) {
        return ResponseEntity.ok(orderService.updateOrder(id, articleId, add));
    }
}
