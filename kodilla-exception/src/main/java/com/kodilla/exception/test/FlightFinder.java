package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    private Map<String, Boolean> airportMap = new HashMap<>();

    public void importAirports() {
        airportMap.put("Heathrow", false);
        airportMap.put("Charleoi", true);
        airportMap.put("Okecie", true);
        airportMap.put("Berlin", true);
        airportMap.put("Zurich", true);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airportAvailabilityMap = new HashMap<>();
        String departureAirport = flight.getDepartureAirport();
        String arrivalAirport = flight.getArrivalAirport();

        if(!airportMap.containsKey(departureAirport)) {
            throw new RouteNotFoundException("The departure airport " + departureAirport + " has not been found!");
        }

        if(!airportMap.containsKey(arrivalAirport)) {
            throw new RouteNotFoundException("The arrival airport " + arrivalAirport + " has not been found!");
        }


        for (Map.Entry<String, Boolean> airport: airportMap.entrySet()) {
            if (airport.getKey().equals(departureAirport)) {
                airportAvailabilityMap.put(airport.getKey(), airport.getValue());
            }
        }

        for (Map.Entry<String, Boolean> airport: airportMap.entrySet()) {
            if (airport.getKey().equals(arrivalAirport)) {
                airportAvailabilityMap.put(airport.getKey(), airport.getValue());
            }
        }

        System.out.println("Result of the search:");
        for (Map.Entry<String, Boolean> airport: airportAvailabilityMap.entrySet()) {
            System.out.println("Airport: " + airport.getKey() + " is available: " + airport.getValue());
        }
    }
}
