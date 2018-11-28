package com.kodilla.good.patterns.challenges.onlineshop.services;

import com.kodilla.good.patterns.challenges.onlineshop.datatransfer.OrderRequest;

public interface OrderService {

    boolean checkIfOrderRequestIsValid(OrderRequest orderRequest);

}
