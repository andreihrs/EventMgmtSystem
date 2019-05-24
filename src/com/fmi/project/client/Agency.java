package com.fmi.project.client;

public class Agency extends Client {

    private int noOfBookings;
    private int discount;
    private String companyName;

    public Agency(int pricePaid, boolean firstTimeCustomer, String emailListSubscription, int noOfBookings, int discount, String companyName) {
        super(pricePaid, firstTimeCustomer, emailListSubscription);
        this.noOfBookings = noOfBookings;
        this.discount = discount;
        this.companyName = companyName;
    }

    public Agency(int noOfBookings, boolean pastCommission, int discount, String companyName) {
        this.noOfBookings = noOfBookings;
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
