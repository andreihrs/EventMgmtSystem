package com.fmi.project.location;

public class LocateRegion extends Location {

    private String venueRegion;

    public LocateRegion(boolean isFull, String placeName, String meansOfBooking, boolean acceptsBooking, String city, String venueRegion) {
        super(isFull, placeName, meansOfBooking, acceptsBooking, city);
        this.venueRegion = venueRegion;
        noOfPlacesAvailable -= 1;
    }

    public LocateRegion() {
    }

    public LocateRegion(String venueRegion) {
        this.venueRegion = venueRegion;
    }

    public String getVenueRegion() {
        return venueRegion;
    }

    public void setVenueRegion(String venueRegion) {
        this.venueRegion = venueRegion;
    }

    @Override
    public String toString() {
        return "LocateRegion{" +
                "venueRegion='" + venueRegion + '\'' +
                ", noOfPlacesAvailable=" + noOfPlacesAvailable +
                ", placeName='" + placeName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
