package com.gridnine.testing;

import java.time.temporal.ChronoUnit;

public class Rule3 implements Apply<Flight> {
    @Override
    public  boolean ok(Flight flight) {
        int  tmp = 0;
        if ( flight.getSegments().size() >= 2)
        {
            for (int i = 1; i < flight.getSegments().size(); i ++) {
                tmp += ChronoUnit.HOURS.between(flight.getSegments().get(i-1).getArrivalDate(), flight.getSegments().get(i).getDepartureDate());
                if (tmp > 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
