package com.kodilla.good.patterns.challenges.Food2Door.producers.shops;

import com.kodilla.good.patterns.challenges.Food2Door.model.Order;
import com.kodilla.good.patterns.challenges.Food2Door.model.Product;
import com.kodilla.good.patterns.challenges.Food2Door.producers.FoodProducer;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class GlutenFreeShop extends FoodProducer {


    public GlutenFreeShop(String foodProducerName, List<Product> productListOfProducer) {
        super(foodProducerName, productListOfProducer);
    }

    //This shop gives a 15% discount for ordering on monday
    @Override
    public double process(Order order) {
        double orderPrice = getPriceOfOrder(order);

        if(isItMonday()) {
            return orderPrice * 0.85;
        }

        System.out.println("Ordering at: " + this.getFoodProducerName());
        System.out.println("Final price: " + orderPrice);
        return orderPrice;
    }

    public boolean isItMonday() {
        boolean isItDiscountDay = false;

        LocalDate today = LocalDate.now();

        if (today.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
            isItDiscountDay = true;
        }

        return isItDiscountDay;
    }
}
