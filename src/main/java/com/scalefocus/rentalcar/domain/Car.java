// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This model class.
 * represents Cars.
 * table from the Database.
 */

@Entity
@Table(name = "CARS")
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "CAR_ID")
    private Long id;

    @Column(name = "CAR_BRAND")
    private String carBrand;

    @Column(name = "CAR_MODEL")
    private String carModel;

    @Column(name = "CHARGE")
    private Double charge;

    @Column(name = "LOCATION_ADDRESS")
    private String locationAddress;

    @Column(name = "LONGITUDE")
    private String latitude;

    @Column(name = "LATITUDE")
    private String longitude;


    public Car() {
    }

    /**
     * @param carBrand - brand of the car.
     * @param carModel - model of the car.
     * @param charge   - charge of the car.
     */

    public Car(String carBrand, String carModel, Double charge) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.charge = charge;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
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
