package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearcher {
    public void FlightSearcher(Flight flight) throws RouteNotFoundException{

        Map<String, Boolean> availableAirports = new HashMap<>();

        availableAirports.put("Lotnisko A", true);
        availableAirports.put("Lotnisko B", true);
        availableAirports.put("Lotnisko C", false);

            String arrival = flight.getArrivalAirport();
            if (!availableAirports.containsKey(arrival) || !availableAirports.get(arrival)) {
                throw new RouteNotFoundException("Nie można znaleźć lotu do lotniska: " + arrival);
            } else {
                System.out.println("Znaleziono lot do lotniska: " + arrival);
                // Tutaj możesz dodać logikę obsługi znalezionego lotu
            }
        }

}
