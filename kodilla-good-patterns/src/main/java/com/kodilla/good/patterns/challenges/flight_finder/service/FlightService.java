package com.kodilla.good.patterns.challenges.flight_finder.service;

import com.kodilla.good.patterns.challenges.flight_finder.database.FlightRepository;
import com.kodilla.good.patterns.challenges.flight_finder.model.City;
import com.kodilla.good.patterns.challenges.flight_finder.model.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class FlightService {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public Set<String> getAllFlightDestinationsFromCity(String departureCity) {
        Set<City> setOfCities = flightRepository.getSetOfCities();

        Set<String> availableFlightDestinations = setOfCities.stream()
                .filter(city -> city.getName().equals(departureCity))
                .flatMap(city -> city.getFlightLocations().stream())
                .collect(Collectors.toSet());

        return availableFlightDestinations;
    }

    public Set<String> getAllFlightsToCity(String arrivalCity) {
        Set<City> setOfCites = flightRepository.getSetOfCities();

        Set<String> availableFlightsToDestination = setOfCites.stream()
                .filter(city -> city.getFlightLocations().contains(arrivalCity))
                .map(city -> city.getName())
                .collect(Collectors.toSet());

        return availableFlightsToDestination;
    }

    public Set<String> getAllFlightsToCityWithOneTransfer(String departureCity, String arrivalCity) {
        Set<String> transferCities = new HashSet<>();
        Set<String> setOfCitiesWithFlightToFinalDestination = getAllFlightsToCity(arrivalCity);
        Set<String> setOfDestinationsFromStartCity = getAllFlightDestinationsFromCity(departureCity);

        for (String city : setOfCitiesWithFlightToFinalDestination) {
            if (setOfDestinationsFromStartCity.contains(city)) {
                transferCities.add(city);
            }
        }

        return transferCities;
    }
}
