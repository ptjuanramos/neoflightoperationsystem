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

package com.neoflightoperationsystemapi.entities;

import com.neoflightoperationsystemapi.models.enums.BidStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.UUID;

@Entity(name = "flight")
@Table(name = "flight")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany
    @Column(name = "airline")
    private AirlineEntity airlineEntity;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "route_code")
    private String routeCode;

    @Column(name = "route_leg")
    private String routeLeg;

    @OneToMany
    @Column(name = "departure_airport")
    private AirportEntity departureAirport;

    @OneToMany
    @Column(name = "arrival_airport")
    private AirportEntity arrivalAirport;

    @ManyToMany
    @Column(name = "alternate_airports")
    private Collection<AirportEntity> alternateAirports;

    @Column(name = "expected_departure_date_time")
    private LocalDateTime expectedDepartureDateAndTime;

    @Column(name = "expected_arrival_date_time")
    private LocalDateTime expectedArrivalDateAndTime;

    @Column(name = "flight_level")
    private int flightLevel;

    private long distance;

    @Column(name = "flight_time")
    private LocalTime flightTime;

    private String route; // Maybe this should be validated with an existent one

    private String remarks;

    @Column(name = "actual_departure_date_time")
    private LocalDateTime actualDepartureDateAndTime;

    @Column(name = "actual_arrival_date_time")
    private LocalDateTime actualArrivalDateAndTime;

    @Column(name = "block_date_time")
    private LocalDateTime blockDateAndTime;

    private BidStatus status;

    private boolean visible;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AirlineEntity getAirlineEntity() {
        return airlineEntity;
    }

    public void setAirlineEntity(AirlineEntity airlineEntity) {
        this.airlineEntity = airlineEntity;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteLeg() {
        return routeLeg;
    }

    public void setRouteLeg(String routeLeg) {
        this.routeLeg = routeLeg;
    }

    public AirportEntity getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportEntity departureAirport) {
        this.departureAirport = departureAirport;
    }

    public AirportEntity getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(AirportEntity arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Collection<AirportEntity> getAlternateAirports() {
        return alternateAirports;
    }

    public void setAlternateAirports(Collection<AirportEntity> alternateAirports) {
        this.alternateAirports = alternateAirports;
    }

    public LocalDateTime getExpectedDepartureDateAndTime() {
        return expectedDepartureDateAndTime;
    }

    public void setExpectedDepartureDateAndTime(LocalDateTime expectedDepartureDateAndTime) {
        this.expectedDepartureDateAndTime = expectedDepartureDateAndTime;
    }

    public LocalDateTime getExpectedArrivalDateAndTime() {
        return expectedArrivalDateAndTime;
    }

    public void setExpectedArrivalDateAndTime(LocalDateTime expectedArrivalDateAndTime) {
        this.expectedArrivalDateAndTime = expectedArrivalDateAndTime;
    }

    public int getFlightLevel() {
        return flightLevel;
    }

    public void setFlightLevel(int flightLevel) {
        this.flightLevel = flightLevel;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        this.flightTime = flightTime;
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

    public LocalDateTime getActualDepartureDateAndTime() {
        return actualDepartureDateAndTime;
    }

    public void setActualDepartureDateAndTime(LocalDateTime actualDepartureDateAndTime) {
        this.actualDepartureDateAndTime = actualDepartureDateAndTime;
    }

    public LocalDateTime getActualArrivalDateAndTime() {
        return actualArrivalDateAndTime;
    }

    public void setActualArrivalDateAndTime(LocalDateTime actualArrivalDateAndTime) {
        this.actualArrivalDateAndTime = actualArrivalDateAndTime;
    }

    public LocalDateTime getBlockDateAndTime() {
        return blockDateAndTime;
    }

    public void setBlockDateAndTime(LocalDateTime blockDateAndTime) {
        this.blockDateAndTime = blockDateAndTime;
    }

    public BidStatus getStatus() {
        return status;
    }

    public void setStatus(BidStatus status) {
        this.status = status;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

