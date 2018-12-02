package com.kodilla.good.patterns.challenges.flight_finder.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class City {
    private String name;
    private Set<String> flightLocations = new HashSet<>();

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<String> getFlightLocations() {
        return flightLocations;
    }

    public void addFlightLocation(String city) {
        if(!city.equals(this.name)) {
            flightLocations.add(city);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
