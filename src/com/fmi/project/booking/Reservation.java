package com.fmi.project.booking;

import com.fmi.project.event.Event;

import java.util.Date;

public class Reservation extends Booking {

    private int noSeats;
    private boolean upsellPackage;

    public Reservation(int price, Event event, boolean optionToResell, Date expirationDate, Date startBookingDate, boolean hasInvitedFriends, boolean cancellationAvailable, int noSeats, boolean upsellPackage) {
        super(price, event, optionToResell, expirationDate, startBookingDate, hasInvitedFriends, cancellationAvailable);
        this.noSeats = noSeats;
        this.upsellPackage = upsellPackage;
    }

    public Reservation() {
    }

    public int getNoSeats() {
        return noSeats;
    }

    public void setNoSeats(int noSeats) {
        this.noSeats = noSeats;
    }

    public boolean isUpsellPackage() {
        return upsellPackage;
    }

    public void setUpsellPackage(boolean upsellPackage) {
        this.upsellPackage = upsellPackage;
    }
}
