package com.kodilla.good.patterns.challenges.onlineshop.repositories;

import com.kodilla.good.patterns.challenges.onlineshop.model.Product;

import java.util.List;

public class GameProductsRepository implements ProductRepository {

    @Override
    public int getProductQuantity(Product product) {
        int quantityOfProduct = 2;
        System.out.printf("The quantity of %s is %d\n", product.getProductName(), quantityOfProduct);
        return quantityOfProduct;
    }

    @Override
    public List<Product> getAvailableProducts() {
        return null;
    }
}
