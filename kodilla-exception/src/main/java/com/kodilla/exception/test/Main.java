package com.kodilla.exception.test;

public class Main {
    public static void main(String[] args) {
        FlightSearcher finder = new FlightSearcher();
        Flight myFlight = new Flight("Lotnisko A", "Lotnisko C");

        try {
            finder.FlightSearcher(myFlight);
        } catch (RouteNotFoundException e) {
            System.out.println("Wyjątek: " + e.getMessage());
        } finally {
            System.out.println("Proces zakończony");
        }

    }
}
