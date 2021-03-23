package com.gridnine.testing;

import java.time.LocalDateTime;

public class Rule1 implements Apply<Flight> {
    @Override
    public  boolean ok(Flight flight) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime lastDeparture = flight.getSegments().get(flight.getSegments().size() - 1).getDepartureDate();
        return localDateTime.isAfter(lastDeparture);
    }
}
