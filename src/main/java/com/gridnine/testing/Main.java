package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Все записи");
        System.out.println("======================");
        FlightBuilder.createFlights().stream().forEach(flight -> System.out.println(flight.toString()));
        System.out.println("======================");
        System.out.println("Вылет до текущ момента времени");
        System.out.println("======================");
        List<Apply> conditionList = new ArrayList<>();
        conditionList.add(new Rule1());
        FlightBuilder.createFlights().stream().filter(flight -> {
            for (Apply apply : conditionList) {
                if (apply.ok(flight)) {
                    return false;
                }
            }
            return true;
                }
        ).forEach(flight -> System.out.println(flight.getSegments()));
        System.out.println("======================");
        System.out.println("Сегменты с датой прилета раньше даты вылета");
        System.out.println("======================");

        conditionList.set(0,new Rule2());
        FlightBuilder.createFlights().stream().filter(flight -> {
                    for (Apply apply : conditionList) {
                        if (apply.ok(flight)) {
                            return false;
                        }
                    }
                    return true;
                }
        ).forEach(flight -> System.out.println(flight.getSegments()));

        System.out.println("======================");
        System.out.println("Общее время на земле превышает два часа");
        System.out.println("======================");
        conditionList.set(0,new Rule3());
        FlightBuilder.createFlights().stream().filter(flight -> {
                    for (Apply apply : conditionList) {
                        if (apply.ok(flight)) {
                            return false;
                        }
                    }
                    return true;
                }
        ).forEach(flight -> System.out.println(flight.getSegments()));

        System.out.println("======================");
        System.out.println("Все правила вместе");
        System.out.println("======================");
        conditionList.set(0,new Rule3());
        conditionList.add(new Rule2());
        conditionList.add(new Rule1());
        FlightBuilder.createFlights().stream().filter(flight -> {
                    for (Apply apply : conditionList) {
                        if (apply.ok(flight)) {
                            return false;
                        }
                    }
                    return true;
                }
        ).forEach(flight -> System.out.println(flight.getSegments()));
    }
}
