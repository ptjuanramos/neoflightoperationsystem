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
import lombok.Getter;
import lombok.Setter;

import javax.measure.unit.Unit;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "flight_plan")
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
}
