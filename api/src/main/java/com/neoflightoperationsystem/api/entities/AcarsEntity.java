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

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = "acars")
@Table(name = "acars")
public class AcarsEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "pirep_id")
    private UUID pirepId;

    private int type;

    @Column(name = "navigation_type")
    private int navigationType;

    private float latitude;

    private float longitude;

    private int distance;

    private int heading;

    private int altitude;

    @Column(name = "vertical_speed")
    private int verticalSpeed;

    @Column(name = "ground_speed")
    private int groundSpeed;

    private int transponder;

    @Column(name = "create_date_time")
    private Timestamp createDateAndTime;

    @Column(name = "sim_date_time")
    private Timestamp simDateAndTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPirepId() {
        return pirepId;
    }

    public void setPirepId(UUID pirepId) {
        this.pirepId = pirepId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNavigationType() {
        return navigationType;
    }

    public void setNavigationType(int navigationType) {
        this.navigationType = navigationType;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getVerticalSpeed() {
        return verticalSpeed;
    }

    public void setVerticalSpeed(int verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    public int getGroundSpeed() {
        return groundSpeed;
    }

    public void setGroundSpeed(int groundSpeed) {
        this.groundSpeed = groundSpeed;
    }

    public int getTransponder() {
        return transponder;
    }

    public void setTransponder(int transponder) {
        this.transponder = transponder;
    }

    public Timestamp getCreateDateAndTime() {
        return createDateAndTime;
    }

    public void setCreateDateAndTime(Timestamp createDateAndTime) {
        this.createDateAndTime = createDateAndTime;
    }

    public Timestamp getSimDateAndTime() {
        return simDateAndTime;
    }

    public void setSimDateAndTime(Timestamp simDateAndTime) {
        this.simDateAndTime = simDateAndTime;
    }
}
