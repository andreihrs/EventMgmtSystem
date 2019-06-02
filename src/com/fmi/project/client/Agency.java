package com.fmi.project.client;

public class Agency extends Client {

    private int noOfBookings;
    private String companyName;

    public Agency(int pricePaid, boolean firstTimeCustomer, String emailListSubscription, int noOfBookings, String companyName) {
        super(pricePaid, firstTimeCustomer, emailListSubscription);
        this.noOfBookings = noOfBookings;
        this.companyName = companyName;
    }

    public Agency(int noOfBookings, String companyName) {
        this.noOfBookings = noOfBookings;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
