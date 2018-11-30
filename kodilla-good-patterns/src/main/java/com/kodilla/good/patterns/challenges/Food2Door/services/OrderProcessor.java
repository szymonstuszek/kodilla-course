package com.kodilla.good.patterns.challenges.Food2Door.services;

import com.kodilla.good.patterns.challenges.Food2Door.model.Order;
import com.kodilla.good.patterns.challenges.Food2Door.datatransfer.OrderDto;
import com.kodilla.good.patterns.challenges.Food2Door.producers.FoodProducer;
import com.kodilla.good.patterns.challenges.Food2Door.databases.FoodProducerDataBase;
import com.kodilla.good.patterns.challenges.Food2Door.services.information.InfoService;
import com.kodilla.good.patterns.challenges.Food2Door.repositories.OrderRepository;

public class OrderProcessor {
    private FoodProducerDataBase foodProducerDataBase;
    private InfoService infoService;
    private OrderRepository orderRepository;

    public OrderProcessor(FoodProducerDataBase foodProducerDataBase, InfoService infoService,
                          OrderRepository orderRepository) {
        this.foodProducerDataBase = foodProducerDataBase;
        this.infoService = infoService;
        this.orderRepository = orderRepository;
    }


    public OrderDto placeFoodOrder(String foodProducerName, Order order) {
        boolean isOrderProcessingSuccessful = false;
        double priceOfOrder = 0;
        FoodProducer foodProducer = foodProducerDataBase.getFoodProducerByName(foodProducerName);

        if(foodProducer != null) {
            isOrderProcessingSuccessful = foodProducer.checkIfOrderIsValid(order);
        }

        if(isOrderProcessingSuccessful) {
            infoService.sendOrderStatusInformation(true);
            priceOfOrder = foodProducer.process(order);
            orderRepository.saveOrder(order);
            return new OrderDto(priceOfOrder, true);

        } else {
            infoService.sendOrderStatusInformation(false);
            return new OrderDto(priceOfOrder, false);
        }
    }



}
