package com.kodilla.good.patterns.challenges.onlineshop.repositories;

import com.kodilla.good.patterns.challenges.onlineshop.model.Product;

import java.util.List;

public interface ProductRepository {

    int getProductQuantity(Product product);

    List<Product> getAvailableProducts();
}
