package com.kodilla.good.patterns.challenges.onlineshop;

import com.kodilla.good.patterns.challenges.onlineshop.datatransfer.OrderRequest;
import com.kodilla.good.patterns.challenges.onlineshop.model.Order;
import com.kodilla.good.patterns.challenges.onlineshop.model.Product;
import com.kodilla.good.patterns.challenges.onlineshop.model.User;
import com.kodilla.good.patterns.challenges.onlineshop.repositories.GameOrderRepository;
import com.kodilla.good.patterns.challenges.onlineshop.repositories.GameProductsRepository;
import com.kodilla.good.patterns.challenges.onlineshop.services.GameOrderService;
import com.kodilla.good.patterns.challenges.onlineshop.services.MailService;

import java.util.HashMap;
import java.util.Map;

public class OnlineGamingShopApplication {
    public static void main(String[] args) {
        MailService mailService = new MailService();
        GameProductsRepository gameProductsRepository = new GameProductsRepository();
        GameOrderService gameOrderService = new GameOrderService(gameProductsRepository);
        GameOrderRepository gameOrderRepository = new GameOrderRepository();

        OrderProcessor orderProcessor = new OrderProcessor(mailService,
                gameOrderService, gameOrderRepository);

        User user = new User(1L, "testuser");

        Product game1 = new Product("Starcrat", 100.0);
        Product game2 = new Product("Warcraft", 100.0);

        Map<Product, Integer> orderMap = new HashMap<>();
        orderMap.put(game1, 2);
        orderMap.put(game2, 1);

        Order order = new Order(orderMap);

        OrderRequest orderRequest = new OrderRequest(order, user);

        orderProcessor.process(orderRequest);
    }
}
