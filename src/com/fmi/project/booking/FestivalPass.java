package com.fmi.project.booking;

import com.fmi.project.event.Event;

import java.util.Date;

public class FestivalPass extends Ticket{

    private int noDays;
    private String passType;
    private boolean accommodationIncluded;

    public FestivalPass(int price, Event event, boolean optionToResell, Date expirationDate, Date startBookingDate, boolean hasInvitedFriends, boolean cancellationAvailable, boolean VIPstatus, boolean earlyBird, int resalePrice, String bonusIncluded, int noDays, String passType, boolean accommodationIncluded) {
        super(price, event, optionToResell, expirationDate, startBookingDate, hasInvitedFriends, cancellationAvailable, VIPstatus, earlyBird, resalePrice, bonusIncluded);
        this.noDays = noDays;
        this.passType = passType;
        this.accommodationIncluded = accommodationIncluded;
    }

    public FestivalPass(boolean VIPstatus, boolean earlyBird, int resalePrice, String bonusIncluded, int noDays, String passType, boolean accommodationIncluded) {
        super(VIPstatus, earlyBird, resalePrice, bonusIncluded);
        this.noDays = noDays;
        this.passType = passType;
        this.accommodationIncluded = accommodationIncluded;
    }

    public FestivalPass(int noDays, String passType, boolean accommodationIncluded) {
        this.noDays = noDays;
        this.passType = passType;
        this.accommodationIncluded = accommodationIncluded;
    }

    public FestivalPass() {
    }

    public int getNoDays() {
        return noDays;
    }

    public void setNoDays(int noDays) {
        this.noDays = noDays;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }

    public boolean isAccommodationIncluded() {
        return accommodationIncluded;
    }

    public void setAccommodationIncluded(boolean accommodationIncluded) {
        this.accommodationIncluded = accommodationIncluded;
    }
}
