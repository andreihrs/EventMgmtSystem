package com.fmi.project.client;

import com.fmi.project.booking.Booking;

public class Agency extends Client {

    private int noOfBookings;
    private boolean pastCommission;
    private int discount;
    private String companyName;

    public Agency(boolean hasRegistered, boolean hasArrived, Booking[] booking, int pricePaid, boolean firstTimeCustomer, String emailListSubscription, int noOfBookings, boolean pastCommission, int discount, String companyName) {
        super(hasRegistered, hasArrived, booking, pricePaid, firstTimeCustomer, emailListSubscription);
        this.noOfBookings = noOfBookings;
        this.pastCommission = pastCommission;
        this.discount = discount;
        this.companyName = companyName;
    }

    public Agency(int noOfBookings, boolean pastCommission, int discount, String companyName) {
        this.noOfBookings = noOfBookings;
        this.pastCommission = pastCommission;
        this.discount = discount;
        this.companyName = companyName;
    }

    public Agency() {
    }

    public int getNoOfBookings() {
        return noOfBookings;
    }

    public void setNoOfBookings(int noOfBookings) {
        this.noOfBookings = noOfBookings;
    }

    public boolean isPastCommission() {
        return pastCommission;
    }

    public void setPastCommission(boolean pastCommission) {
        this.pastCommission = pastCommission;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
