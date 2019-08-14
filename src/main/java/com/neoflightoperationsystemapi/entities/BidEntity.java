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
import java.util.UUID;

@Entity(name = "bid")
@Table(name = "bid")
public class BidEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany
    @Column(name = "flight")
    private FlightEntity flightEntity;

    @OneToMany
    @Column(name = "pilot")
    private PilotInfoEntity pilotInfoEntity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FlightEntity getFlightEntity() {
        return flightEntity;
    }

    public void setFlightEntity(FlightEntity flightEntity) {
        this.flightEntity = flightEntity;
    }

    public PilotInfoEntity getPilotInfoEntity() {
        return pilotInfoEntity;
    }

    public void setPilotInfoEntity(PilotInfoEntity pilotInfoEntity) {
        this.pilotInfoEntity = pilotInfoEntity;
    }
}
