/*
 * MIT License
 *
 * Copyright (c) 2019 Juan Ramos
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.neoflightoperationsystem.api.entities;

import com.neoflightoperationsystem.flightplan.models.FlightPlan;
import com.neoflightoperationsystem.flightplan.models.enums.FlightplanClass;

import javax.measure.unit.Unit;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "flight_plan")
public class FlightPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "flight_plan_class")
    private FlightplanClass flightplanClass;

    @ManyToOne
    @JoinColumn(
            name = "flight_id",
            nullable = false
    )
    private FlightEntity flightEntity;

    @OneToMany
    @JoinTable(
            name = "flight_plan_alternative_airports",
            joinColumns = @JoinColumn(name = "flight_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "alternative_airport_id")
    )
    private Collection<AirportEntity> alternativeAirportEntities;

    private long distance;

    @Column(nullable = false)
    private String flightLevel;

    @Column(nullable = false)
    private LocalDate flightDate;

    @Column(nullable = false)
    private LocalTime departureTimeUTC;

    @Column(nullable = false)
    private LocalTime flightTime;

    private LocalTime blockTime;

    @Column(nullable = false)
    private long blockFuel;

    @Column(nullable = false)
    private long extraFuel;

    @Column(nullable = false)
    private long zeroFuelWeight;

    @Column(nullable = false)
    private long takeOfWeight;

    @Column(nullable = false)
    private Unit fuelUnitOfMeasure;

    @Column(nullable = false)
    private String route;

    private String remarks;

    private boolean isEtops;

    private String fuelFactor;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FlightplanClass getFlightplanClass() {
        return flightplanClass;
    }

    public void setFlightplanClass(FlightplanClass flightplanClass) {
        this.flightplanClass = flightplanClass;
    }

    public Collection<AirportEntity> getAlternativeAirportEntities() {
        return alternativeAirportEntities;
    }

    public void setAlternativeAirportEntities(Collection<AirportEntity> alternativeAirportEntities) {
        this.alternativeAirportEntities = alternativeAirportEntities;
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
