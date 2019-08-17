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

import com.neoflightoperationsystem.api.models.enums.BidStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "flight")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(
            name = "airline_id",
            nullable = false
    )
    private AirlineEntity airlineEntity;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "route_code")
    private String routeCode;

    @Column(name = "route_leg")
    private String routeLeg;

    @ManyToOne
    @JoinColumn(
            name = "departure_airport_id",
            nullable = false
    )
    private AirportEntity departureAirportEntity;

    @ManyToOne
    @JoinColumn(
            name = "arrival_airport_id",
            nullable = false
    )
    private AirportEntity arrivalAirportEntity;

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

    public AirportEntity getDepartureAirportEntity() {
        return departureAirportEntity;
    }

    public void setDepartureAirportEntity(AirportEntity departureAirportEntity) {
        this.departureAirportEntity = departureAirportEntity;
    }

    public AirportEntity getArrivalAirportEntity() {
        return arrivalAirportEntity;
    }

    public void setArrivalAirportEntity(AirportEntity arrivalAirportEntity) {
        this.arrivalAirportEntity = arrivalAirportEntity;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

