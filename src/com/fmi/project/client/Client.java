package com.fmi.project.client;

import com.fmi.project.booking.*;

public abstract class Client implements Comparable<Client> {

    protected boolean hasRegistered;

    protected boolean hasArrived;

    protected Booking booking;

    protected int pricePaid;

    protected boolean firstTimeCustomer;

    protected String EmailListSubscription;


}
