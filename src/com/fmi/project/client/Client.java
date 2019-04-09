package com.fmi.project.client;

import com.fmi.project.booking.*;

public abstract class Client implements Comparable<Client> {

    protected boolean hasRegistered;
    protected boolean hasArrived;
    protected Booking[] booking;
    protected int pricePaid;
    protected boolean firstTimeCustomer;
    protected String EmailListSubscription;

    public Client(boolean hasRegistered, boolean hasArrived, Booking[] booking, int pricePaid, boolean firstTimeCustomer, String emailListSubscription) {
        this.hasRegistered = hasRegistered;
        this.hasArrived = hasArrived;
        this.booking = booking;
        this.pricePaid = pricePaid;
        this.firstTimeCustomer = firstTimeCustomer;
        EmailListSubscription = emailListSubscription;
    }

    public Client() {
    }

    public boolean isHasRegistered() {
        return hasRegistered;
    }

    public void setHasRegistered(boolean hasRegistered) {
        this.hasRegistered = hasRegistered;
    }

    public boolean isHasArrived() {
        return hasArrived;
    }

    public void setHasArrived(boolean hasArrived) {
        this.hasArrived = hasArrived;
    }

    public Booking[] getBooking() {
        return booking;
    }

    public void setBooking(Booking[] booking) {
        this.booking = booking;
    }

    public int getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(int pricePaid) {
        this.pricePaid = pricePaid;
    }

    public boolean isFirstTimeCustomer() {
        return firstTimeCustomer;
    }

    public void setFirstTimeCustomer(boolean firstTimeCustomer) {
        this.firstTimeCustomer = firstTimeCustomer;
    }

    public String getEmailListSubscription() {
        return EmailListSubscription;
    }

    public void setEmailListSubscription(String emailListSubscription) {
        EmailListSubscription = emailListSubscription;
    }

    @Override
    public int compareTo(Client cl) {
       return Integer.compare(this.pricePaid, cl.pricePaid);
    }
}
