package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.databases.FoodProducerDataBase;
import com.kodilla.good.patterns.challenges.Food2Door.model.Order;
import com.kodilla.good.patterns.challenges.Food2Door.producers.FoodProducer;
import com.kodilla.good.patterns.challenges.Food2Door.producers.shops.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.Food2Door.model.Product;
import com.kodilla.good.patterns.challenges.Food2Door.producers.shops.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.Food2Door.producers.shops.HealthyShop;
import com.kodilla.good.patterns.challenges.Food2Door.repositories.FoodOrderRepository;
import com.kodilla.good.patterns.challenges.Food2Door.repositories.OrderRepository;
import com.kodilla.good.patterns.challenges.Food2Door.services.OrderProcessor;
import com.kodilla.good.patterns.challenges.Food2Door.services.information.InfoService;
import com.kodilla.good.patterns.challenges.Food2Door.services.information.MailService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Food2DoorApplication {
        public static final String EXTRA_FOOD_SHOP = "ExtraFoodShop";
        public static final String HEALTHY_SHOP = "HealthyShop";
        public static final String GLUTEN_FREE_SHOP = "GlutenFreeShop";


    public static void main(String[] args) {
        Product apple = new Product("apple", 2.0);
        Product potatoes = new Product("potatoes", 5.0);

        List<Product> availableProductsList = new ArrayList<>();
        availableProductsList.add(apple);
        availableProductsList.add(potatoes);

        FoodProducer extraFoodShop = new ExtraFoodShop(EXTRA_FOOD_SHOP, availableProductsList);
        FoodProducer healthyShop = new HealthyShop(HEALTHY_SHOP, availableProductsList);
        FoodProducer glutenFreeShop = new GlutenFreeShop(GLUTEN_FREE_SHOP, availableProductsList);

        List<FoodProducer> foodProducers = new ArrayList<>();
        foodProducers.add(extraFoodShop);
        foodProducers.add(healthyShop);
        foodProducers.add(glutenFreeShop);

        FoodProducerDataBase foodProducerDataBase = new FoodProducerDataBase(foodProducers);
        InfoService mailService = new MailService();
        OrderRepository orderRepository = new FoodOrderRepository();

        OrderProcessor orderProcessor = new OrderProcessor(foodProducerDataBase, mailService, orderRepository);

        Map<Product, Integer> orderMap = new HashMap<>();
        orderMap.put(apple, 1000);

        Order order = new Order(orderMap);

        orderProcessor.placeFoodOrder("ExtraFoodShop", order);
        orderProcessor.placeFoodOrder("HealthyShop", order);
        orderProcessor.placeFoodOrder("GlutenFreeShop", order);

    }
}
