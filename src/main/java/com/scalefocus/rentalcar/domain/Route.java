// All Rights Reserved, Copyright © ScaleFocus

package com.scalefocus.rentalcar.domain;

public class Route {

    private String startLocation;
    private String endLocation;


    public Route() {
    }

    public Route(String startLocation, String endLocation) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }
}
