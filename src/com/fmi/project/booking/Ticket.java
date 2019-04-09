package com.fmi.project.booking;

import com.fmi.project.event.Event;

import java.util.Date;

public class Ticket extends Booking {

    protected boolean VIPstatus;
    protected boolean earlyBird;
    protected int resalePrice;
    protected String bonusIncluded;


    public Ticket(int price, Event event, boolean optionToResell, Date expirationDate, Date startBookingDate, boolean hasInvitedFriends, boolean cancellationAvailable, boolean VIPstatus, boolean earlyBird, int resalePrice, String bonusIncluded) {
        super(price, event, optionToResell, expirationDate, startBookingDate, hasInvitedFriends, cancellationAvailable);
        this.VIPstatus = VIPstatus;
        this.earlyBird = earlyBird;
        this.resalePrice = resalePrice;
        this.bonusIncluded = bonusIncluded;
    }

    public Ticket(boolean VIPstatus, boolean earlyBird, int resalePrice, String bonusIncluded) {
        this.VIPstatus = VIPstatus;
        this.earlyBird = earlyBird;
        this.resalePrice = resalePrice;
        this.bonusIncluded = bonusIncluded;
    }

    public Ticket() {
    }

    public boolean isVIPstatus() {
        return VIPstatus;
    }

    public void setVIPstatus(boolean VIPstatus) {
        this.VIPstatus = VIPstatus;
    }

    public boolean isEarlyBird() {
        return earlyBird;
    }

    public void setEarlyBird(boolean earlyBird) {
        this.earlyBird = earlyBird;
    }

    public int getResalePrice() {
        return resalePrice;
    }

    public void setResalePrice(int resalePrice) {
        this.resalePrice = resalePrice;
    }

    public String getBonusIncluded() {
        return bonusIncluded;
    }

    public void setBonusIncluded(String bonusIncluded) {
        this.bonusIncluded = bonusIncluded;
    }
}
