package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
        String departureAirport = flight.getDepartureAirport();
        String arrivalAirport = flight.getArrivalAirport();

        if(!airportMap.containsKey(departureAirport)) {
            throw new RouteNotFoundException("The departure airport " + departureAirport + " has not been found!");
        }

        if(!airportMap.containsKey(arrivalAirport)) {
            throw new RouteNotFoundException("The arrival airport " + arrivalAirport + " has not been found!");
        }

        Map<String, Boolean> airportAvailabilityMap = airportMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(departureAirport) ||
                        entry.getKey().equals(arrivalAirport))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Availability of the route:");
        System.out.println(airportAvailabilityMap);
    }
}
