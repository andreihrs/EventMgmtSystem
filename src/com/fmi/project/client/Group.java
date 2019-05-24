package com.fmi.project.client;


public class Group extends Client{

    private int noPeople;
    private boolean elligibleForReward;

    public Group(int pricePaid, boolean firstTimeCustomer, String emailListSubscription, int noPeople, boolean elligibleForReward) {
        super(pricePaid, firstTimeCustomer, emailListSubscription);
        this.noPeople = noPeople;
        this.elligibleForReward = elligibleForReward;
    }

    public Group(int noPeople, boolean specialEvent, boolean elligibleForReward) {
        this.noPeople = noPeople;
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

    public boolean isElligibleForReward() {
        return elligibleForReward;
    }

    public void setElligibleForReward(boolean elligibleForReward) {
        this.elligibleForReward = elligibleForReward;
    }
}
