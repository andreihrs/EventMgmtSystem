package com.fmi.project.location;

public class LocateSeat extends Location{

    private int seatID;
    private boolean multipleSeats;

    public LocateSeat(boolean isFull, int noOfPlacesAvailable, String placeName, String meansOfBooking, boolean acceptsBooking, String city, int seatID, boolean multipleSeats) {
        super(isFull, noOfPlacesAvailable, placeName, meansOfBooking, acceptsBooking, city);
        this.seatID = seatID;
        this.multipleSeats = multipleSeats;
    }

    public LocateSeat() {
    }

    public LocateSeat(int seatID, boolean multipleSeats) {
        this.seatID = seatID;
        this.multipleSeats = multipleSeats;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public boolean isMultipleSeats() {
        return multipleSeats;
    }

    public void setMultipleSeats(boolean multipleSeats) {
        this.multipleSeats = multipleSeats;
    }

    @Override
    public String toString() {
        return "LocateSeat{" +
                "seatID=" + seatID +
                ", noOfPlacesAvailable=" + noOfPlacesAvailable +
                ", placeName='" + placeName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
