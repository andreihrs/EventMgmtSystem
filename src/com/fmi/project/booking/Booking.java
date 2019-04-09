package com.fmi.project.booking;
import com.fmi.project.event.*;
import java.util.Date;

public abstract class Booking {
    protected int price;
    protected Event event;
    protected boolean optionToResell;
    protected Date expirationDate;
    protected Date startBookingDate;
    protected boolean hasInvitedFriends;
    protected boolean cancellationAvailable;

    public Booking(int price, Event event, boolean optionToResell, Date expirationDate, Date startBookingDate, boolean hasInvitedFriends, boolean cancellationAvailable) {
        this.price = price;
        this.event = event;
        this.optionToResell = optionToResell;
        this.expirationDate = expirationDate;
        this.startBookingDate = startBookingDate;
        this.hasInvitedFriends = hasInvitedFriends;
        this.cancellationAvailable = cancellationAvailable;
    }

    public Booking() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isOptionToResell() {
        return optionToResell;
    }

    public void setOptionToResell(boolean optionToResell) {
        this.optionToResell = optionToResell;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getStartBookingDate() {
        return startBookingDate;
    }

    public void setStartBookingDate(Date startBookingDate) {
        this.startBookingDate = startBookingDate;
    }

    public boolean isHasInvitedFriends() {
        return hasInvitedFriends;
    }

    public void setHasInvitedFriends(boolean hasInvitedFriends) {
        this.hasInvitedFriends = hasInvitedFriends;
    }

    public boolean isCancellationAvailable() {
        return cancellationAvailable;
    }

    public void setCancellationAvailable(boolean cancellationAvailable) {
        this.cancellationAvailable = cancellationAvailable;
    }
}
