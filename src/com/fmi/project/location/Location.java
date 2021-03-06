package com.fmi.project.location;

public abstract class Location {

    protected boolean isFull;
    static protected int noOfPlacesAvailable = 100;
    protected String placeName;
    protected String meansOfBooking; // internet, physical,
    protected boolean acceptsBooking;
    protected String city;

    public Location(boolean isFull, String placeName, String meansOfBooking, boolean acceptsBooking, String city) {
        this.isFull = isFull;
        this.placeName = placeName;
        this.meansOfBooking = meansOfBooking;
        this.acceptsBooking = acceptsBooking;
        this.city = city;
    }

    public Location() {
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getMeansOfBooking() {
        return meansOfBooking;
    }

    public void setMeansOfBooking(String meansOfBooking) {
        this.meansOfBooking = meansOfBooking;
    }

    public boolean isAcceptsBooking() {
        return acceptsBooking;
    }

    public void setAcceptsBooking(boolean acceptsBooking) {
        this.acceptsBooking = acceptsBooking;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "noOfPlacesAvailable=" + noOfPlacesAvailable +
                ", placeName='" + placeName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
