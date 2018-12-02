package com.kodilla.good.patterns.challenges.flight_finder.database;

import com.kodilla.good.patterns.challenges.flight_finder.model.City;
import java.util.Set;

public class FlightRepository {
    private Set<City> setOfCities;

    public FlightRepository(Set<City> setOfCities) {
        this.setOfCities = setOfCities;
    }

    public Set<City> getSetOfCities() {
        return setOfCities;
    }
}
