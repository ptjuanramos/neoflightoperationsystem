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

import javax.persistence.*;
import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "pirep")
public class PirepEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "flight_number")
    private String flightNumber;

    private String routeCode;
    private String routeLeg;
    private AirlineEntity airline;
    private AircraftEntity aircraft;
    private AirportEntity departureAirport;
    private AirportEntity arrivalAirport;
    private AirportEntity alternateAirport;
    private float distance;
    private float plannedDistance;
    private Time blockTime;
    private Time flightTime;
    private Time plannedFlightTime;
    private float zeroFuelWeight;
    private float blockFuelWeight;
    private float fuelUsedWeight;


    //Remarks
    //rwy arr and dep?

}
