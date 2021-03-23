package com.gridnine.testing;

public class Rule2 implements Apply<Flight> {
    @Override
    public  boolean ok(Flight flight) {
        for (Segment s : flight.getSegments() ) {
            if (s.getArrivalDate().isBefore(s.getDepartureDate())) {
                return true;
            }
        }
        return false;
    }
}
