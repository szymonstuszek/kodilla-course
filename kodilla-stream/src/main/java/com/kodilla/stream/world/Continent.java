package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private List<Country> listOfCountries = new ArrayList<>();

    public Continent(List<Country> listOfCountries) {
        this.listOfCountries = listOfCountries;
    }

    public List<Country> getListOfCountries() {
        return listOfCountries;
    }
}
