package com.kodilla.good.patterns.challenges.onlineshop.services;

import com.kodilla.good.patterns.challenges.onlineshop.datatransfer.OrderRequest;
import com.kodilla.good.patterns.challenges.onlineshop.model.Product;
import com.kodilla.good.patterns.challenges.onlineshop.repositories.GameProductsRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GameOrderService implements OrderService {
    private GameProductsRepository gameRepository;

    public GameOrderService(GameProductsRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public boolean checkIfOrderRequestIsValid(OrderRequest orderRequest) {
        boolean isRequestValid = false;

        List<Product> requestedProductList = getRequestedProductsList(orderRequest);
        isRequestValid = checkIfAllProductsAreAvailable(requestedProductList);

        System.out.println("Is the order request valid: " + isRequestValid);
        return isRequestValid;
    }

    private List<Product> getRequestedProductsList(OrderRequest orderRequest) {
        List<Product> requestedProductsList =
                orderRequest.getOrder().getOrderedProductsMap()
                .entrySet().stream()
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        return requestedProductsList;
    }

    private boolean checkIfAllProductsAreAvailable(List<Product> productList) {
        boolean allProductsAvailable = true;

        boolean isAProductUnavailable = productList.stream()
                .map(gameRepository::getProductQuantity)
                .anyMatch(quantity -> quantity.equals(0));

        if(isAProductUnavailable) allProductsAvailable = false;

        return allProductsAvailable;
    }
}
