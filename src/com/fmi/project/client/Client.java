package com.fmi.project.client;

// TO-DO: import com.fmi.project.booking.*;

public abstract class Client implements Comparable<Client> {

    protected int pricePaid;
    protected boolean firstTimeCustomer;
    protected String EmailListSubscription;

    public Client(int pricePaid, boolean firstTimeCustomer, String emailListSubscription) {
        this.pricePaid = pricePaid;
        this.firstTimeCustomer = firstTimeCustomer;
        EmailListSubscription = emailListSubscription;
    }

    public Client() {
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

    @Override
    public String toString() {
        return "Location{" +
                "nameOfEmailList=" + EmailListSubscription  +
                ", pricePaid='" + pricePaid + '\'' +
                ", firstTimeCustomer: '" + firstTimeCustomer + '\'' +
                '}';
    }
}
