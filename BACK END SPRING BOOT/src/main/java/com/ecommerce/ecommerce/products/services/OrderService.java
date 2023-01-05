package com.ecommerce.ecommerce.products.services;

import com.ecommerce.ecommerce.products.model.Article;
import com.ecommerce.ecommerce.products.model.Order;
import com.ecommerce.ecommerce.products.repositories.ArticleRepository;
import com.ecommerce.ecommerce.products.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ArticleRepository articleRepository;

    public OrderService(OrderRepository orderRepository, ArticleRepository articleRepository) {
        this.orderRepository = orderRepository;
        this.articleRepository = articleRepository;
    }

    public Order createOrder(List<Long> articlesIds) {
        Set<Article> articles = articlesIds.stream()
                .map(articleRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setArticles(articles);
        articles.forEach(article -> article.getOrders().add(order));
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(Long orderId, Long articleId, boolean add) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        if (add) {
            order.getArticles().add(article);
            article.getOrders().add(order);
        } else {
            order.getArticles().remove(article);
            article.getOrders().remove(order);
        }
        return orderRepository.save(order);
    }

}
