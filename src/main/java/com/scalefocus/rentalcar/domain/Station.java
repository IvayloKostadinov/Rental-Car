// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This model class.
 * represents Stations.
 * table from the Database.
 */


@Entity
@Table(name = "STATIONS")
public class Station {
    @Id
    @GeneratedValue
    @Column(name = "STATION_ID")
    private Long id;

    @Column(name = "LOCATION_ADDRESS")
    private String locationAddress;

    @Column(name = "LONGITUDE")
    private String latitude;

    @Column(name = "LATITUDE")
    private String longitude;

    public Station() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
