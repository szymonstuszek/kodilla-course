package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        flightFinder.importAirports();

        Flight flight1 = new Flight("Berlin", "Okecie");
        Flight flight2 = new Flight("Berlin", "Marsylia");

        try {
            flightFinder.findFlight(flight1);
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        }

        try {
            flightFinder.findFlight(flight2);
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Search completed.");
    }
}
