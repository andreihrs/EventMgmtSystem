package com.fmi.project.client;

import com.fmi.project.booking.Booking;

public class Group extends Client{

    private int noPeople;
    private boolean specialEvent;
    private boolean elligibleForReward;

    public Group(boolean hasRegistered, boolean hasArrived, Booking[] booking, int pricePaid, boolean firstTimeCustomer, String emailListSubscription, int noPeople, boolean specialEvent, boolean elligibleForReward) {
        super(hasRegistered, hasArrived, booking, pricePaid, firstTimeCustomer, emailListSubscription);
        this.noPeople = noPeople;
        this.specialEvent = specialEvent;
        this.elligibleForReward = elligibleForReward;
    }

    public Group(int noPeople, boolean specialEvent, boolean elligibleForReward) {
        this.noPeople = noPeople;
        this.specialEvent = specialEvent;
        this.elligibleForReward = elligibleForReward;
    }

    public Group() {
    }

    public int getNoPeople() {
        return noPeople;
    }

    public void setNoPeople(int noPeople) {
        this.noPeople = noPeople;
    }

    public boolean isSpecialEvent() {
        return specialEvent;
    }

    public void setSpecialEvent(boolean specialEvent) {
        this.specialEvent = specialEvent;
    }

    public boolean isElligibleForReward() {
        return elligibleForReward;
    }

    public void setElligibleForReward(boolean elligibleForReward) {
        this.elligibleForReward = elligibleForReward;
    }
}
