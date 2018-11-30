package com.kodilla.good.patterns.challenges.Food2Door.databases;

import com.kodilla.good.patterns.challenges.Food2Door.producers.FoodProducer;

import java.util.List;
import java.util.Optional;

public class FoodProducerDataBase {
    private List<FoodProducer> foodProducers;

    public FoodProducerDataBase(List<FoodProducer> foodProducers) {
        this.foodProducers = foodProducers;
    }

    public List<FoodProducer> getFoodProducersList() {
        return foodProducers;
    }

    public FoodProducer getFoodProducerByName(String foodProducerName) {
        Optional<FoodProducer> matchingFoodProducer = foodProducers.stream()
                .filter(producer -> producer.getFoodProducerName().equals(foodProducerName))
                .findFirst();

        FoodProducer resultFoodProducer = matchingFoodProducer.orElse(null);

        return resultFoodProducer;
    }

    public void addNewFoodProducer(FoodProducer foodProducer) {
        this.foodProducers.add(foodProducer);
    }
}
