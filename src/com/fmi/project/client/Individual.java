package com.fmi.project.client;

import com.fmi.project.booking.Booking;

public class Individual extends Client{

    private int previousCheckins;
    private int couponsUsed;
    private int rewardsClaimed;

    public Individual(boolean hasRegistered, boolean hasArrived, Booking[] booking, int pricePaid, boolean firstTimeCustomer, String emailListSubscription, int previousCheckins, int couponsUsed, int rewardsClaimed) {
        super(hasRegistered, hasArrived, booking, pricePaid, firstTimeCustomer, emailListSubscription);
        this.previousCheckins = previousCheckins;
        this.couponsUsed = couponsUsed;
        this.rewardsClaimed = rewardsClaimed;
    }

    public Individual(int previousCheckins, int couponsUsed, int rewardsClaimed) {
        this.previousCheckins = previousCheckins;
        this.couponsUsed = couponsUsed;
        this.rewardsClaimed = rewardsClaimed;
    }

    public Individual() {
    }

    public int getPreviousCheckins() {
        return previousCheckins;
    }

    public void setPreviousCheckins(int previousCheckins) {
        this.previousCheckins = previousCheckins;
    }

    public int getCouponsUsed() {
        return couponsUsed;
    }

    public void setCouponsUsed(int couponsUsed) {
        this.couponsUsed = couponsUsed;
    }

    public int getRewardsClaimed() {
        return rewardsClaimed;
    }

    public void setRewardsClaimed(int rewardsClaimed) {
        this.rewardsClaimed = rewardsClaimed;
    }
}
