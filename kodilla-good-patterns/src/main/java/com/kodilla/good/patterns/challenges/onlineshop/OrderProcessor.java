package com.kodilla.good.patterns.challenges.onlineshop;

import com.kodilla.good.patterns.challenges.onlineshop.datatransfer.OrderDto;
import com.kodilla.good.patterns.challenges.onlineshop.datatransfer.OrderRequest;
import com.kodilla.good.patterns.challenges.onlineshop.repositories.OrderRepository;
import com.kodilla.good.patterns.challenges.onlineshop.services.InfoService;
import com.kodilla.good.patterns.challenges.onlineshop.services.OrderService;

public class OrderProcessor {
    private InfoService infoService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(InfoService infoService, OrderService orderService,
                          OrderRepository orderRepository) {
        this.infoService = infoService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean isValidOrder = orderService.checkIfOrderRequestIsValid(orderRequest);

        if(isValidOrder) {
            infoService.sendInformation(orderRequest.getUser());
            orderRepository.saveOrder(orderRequest.getOrder(), orderRequest.getUser());
            return new OrderDto(orderRequest.getOrder(), true);
        } else {
            return new OrderDto(orderRequest.getOrder(), false);
        }
    }
}
