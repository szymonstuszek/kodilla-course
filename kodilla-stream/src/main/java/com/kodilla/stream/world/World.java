package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Continent> listOfContinents = new ArrayList<>();

    public World(List<Continent> listOfContinents) {
        this.listOfContinents = listOfContinents;
    }

    public BigDecimal getPeopleQuantity() {
        return listOfContinents.stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
