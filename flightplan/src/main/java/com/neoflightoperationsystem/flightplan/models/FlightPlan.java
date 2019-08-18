package com.neoflightoperationsystem.flightplan.models;

import com.neoflightoperationsystem.flightplan.models.enums.FlightplanClass;

import javax.measure.unit.Unit;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

/**
 *
 */
public class FlightPlan {

    private FlightplanClass flightplanClass;
    private String airlineICAO;
    private String flightNumber;
    private String departureAirportICAO;
    private String arrivalAirportICAO;
    private Collection<String> alternativeAirportsICAO;
    private String flightLevel;
    private LocalDate flightDate;
    private LocalTime departureTimeUTC;
    private LocalTime flightTime;
    private LocalTime blockTime;
    private long blockFuel;
    private long extraFuel;
    private long zeroFuelWeight;
    private long takeOfWeight;
    private Unit fuelUnitOfMeasure;
    private String route;
    private String remarks;
    private boolean isEtops;
    private String fuelFactor;
}
