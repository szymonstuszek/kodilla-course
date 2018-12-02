package com.kodilla.good.patterns.challenges.flight_finder;


import com.kodilla.good.patterns.challenges.flight_finder.database.FlightRepository;
import com.kodilla.good.patterns.challenges.flight_finder.model.City;
import com.kodilla.good.patterns.challenges.flight_finder.service.FlightService;

import java.util.*;

public class FlightFinderApp {
    public static void main(String[] args) {
        City warsaw = new City("Warsaw");
        City cracow = new City("Cracow");
        City poznan = new City("Poznan");
        City lodz = new City("Lodz");
        City lublin = new City("Lublin");

        warsaw.addFlightLocation("Poznan");
        warsaw.addFlightLocation("Lodz");
        warsaw.addFlightLocation("Lublin");

        poznan.addFlightLocation("Lodz");

        cracow.addFlightLocation("Lodz");

        lublin.addFlightLocation("Lodz");

        lodz.addFlightLocation("Warsaw");

        Set<City> setOfCities = new HashSet<>();
        setOfCities.add(warsaw);
        setOfCities.add(cracow);
        setOfCities.add(poznan);
        setOfCities.add(lodz);
        setOfCities.add(lublin);

        FlightRepository flightRepository = new FlightRepository(setOfCities);


        FlightService flightService = new FlightService(flightRepository);

        System.out.println("To what cities can you fly from Warsaw?");
        Set<String> setOfDestinations = flightService.getAllFlightDestinationsFromCity("Warsaw");
        setOfDestinations.forEach(System.out::println);

        System.out.println("\nFrom what cities can you fly to Lodz?");
        Set<String> setOfFlightsToCity = flightService.getAllFlightsToCity("Lodz");
        setOfFlightsToCity.forEach(System.out::println);

        System.out.println("\nFlight from Warsaw to Lodz with a transfer in:");
        Set<String> transferSet = flightService.getAllFlightsToCityWithOneTransfer("Warsaw", "Lodz");
        transferSet.forEach(System.out::println);
    }
}
