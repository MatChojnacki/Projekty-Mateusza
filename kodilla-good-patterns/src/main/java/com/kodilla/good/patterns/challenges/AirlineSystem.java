package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Klasa reprezentująca lot
class Flight {
    private String departureCity;
    private String destinationCity;

    public Flight(String departureCity, String destinationCity) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return departureCity.equals(flight.departureCity) &&
                destinationCity.equals(flight.destinationCity);
    }

    @Override
    public int hashCode() {
        return departureCity.hashCode() + destinationCity.hashCode();
    }
}

// Serwis do obsługi lotów
class FlightService {
    private List<Flight> flights;

    public FlightService() {
        this.flights = new ArrayList<>();
    }

    public void addFlight(String departureCity, String destinationCity) {
        Flight flight = new Flight(departureCity, destinationCity);
        flights.add(flight);
    }

    public List<Flight> findFlightsFromCity(String departureCity) {
        return flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(departureCity))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsToCity(String destinationCity) {
        return flights.stream()
                .filter(flight -> flight.getDestinationCity().equals(destinationCity))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsThroughCity(String intermediateCity, String destinationCity) {
        return flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(intermediateCity))
                .filter(flight -> flight.getDestinationCity().equals(destinationCity))
                .collect(Collectors.toList());
    }
}

public class AirlineSystem {
    public static void main(String[] args) {
        FlightService flightService = new FlightService();

        // Dodaj kilka lotów
        flightService.addFlight("GDANSK", "WROCLAW");
        flightService.addFlight("WARSZAWA", "KRAKOW");
        flightService.addFlight("KRAKOW", "WROCLAW");
        flightService.addFlight("GDANSK", "KRAKOW");

        // Przykłady użycia serwisu
        System.out.println("Flights from GDANSK: " + flightService.findFlightsFromCity("GDANSK"));
        System.out.println("Flights to WROCLAW: " + flightService.findFlightsToCity("WROCLAW"));
        System.out.println("Flights through KRAKOW to WROCLAW: " +
                flightService.findFlightsThroughCity("KRAKOW", "WROCLAW"));
    }
}

