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

    public FlightplanClass getFlightplanClass() {
        return flightplanClass;
    }

    public void setFlightplanClass(FlightplanClass flightplanClass) {
        this.flightplanClass = flightplanClass;
    }

    public String getAirlineICAO() {
        return airlineICAO;
    }

    public void setAirlineICAO(String airlineICAO) {
        this.airlineICAO = airlineICAO;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirportICAO() {
        return departureAirportICAO;
    }

    public void setDepartureAirportICAO(String departureAirportICAO) {
        this.departureAirportICAO = departureAirportICAO;
    }

    public String getArrivalAirportICAO() {
        return arrivalAirportICAO;
    }

    public void setArrivalAirportICAO(String arrivalAirportICAO) {
        this.arrivalAirportICAO = arrivalAirportICAO;
    }

    public Collection<String> getAlternativeAirportsICAO() {
        return alternativeAirportsICAO;
    }

    public void setAlternativeAirportsICAO(Collection<String> alternativeAirportsICAO) {
        this.alternativeAirportsICAO = alternativeAirportsICAO;
    }

    public String getFlightLevel() {
        return flightLevel;
    }

    public void setFlightLevel(String flightLevel) {
        this.flightLevel = flightLevel;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalTime getDepartureTimeUTC() {
        return departureTimeUTC;
    }

    public void setDepartureTimeUTC(LocalTime departureTimeUTC) {
        this.departureTimeUTC = departureTimeUTC;
    }

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        this.flightTime = flightTime;
    }

    public LocalTime getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(LocalTime blockTime) {
        this.blockTime = blockTime;
    }

    public long getBlockFuel() {
        return blockFuel;
    }

    public void setBlockFuel(long blockFuel) {
        this.blockFuel = blockFuel;
    }

    public long getExtraFuel() {
        return extraFuel;
    }

    public void setExtraFuel(long extraFuel) {
        this.extraFuel = extraFuel;
    }

    public long getZeroFuelWeight() {
        return zeroFuelWeight;
    }

    public void setZeroFuelWeight(long zeroFuelWeight) {
        this.zeroFuelWeight = zeroFuelWeight;
    }

    public long getTakeOfWeight() {
        return takeOfWeight;
    }

    public void setTakeOfWeight(long takeOfWeight) {
        this.takeOfWeight = takeOfWeight;
    }

    public Unit getFuelUnitOfMeasure() {
        return fuelUnitOfMeasure;
    }

    public void setFuelUnitOfMeasure(Unit fuelUnitOfMeasure) {
        this.fuelUnitOfMeasure = fuelUnitOfMeasure;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isEtops() {
        return isEtops;
    }

    public void setEtops(boolean etops) {
        isEtops = etops;
    }

    public String getFuelFactor() {
        return fuelFactor;
    }

    public void setFuelFactor(String fuelFactor) {
        this.fuelFactor = fuelFactor;
    }
}
