package com.fmi.project.booking;
import com.fmi.project.event.*;
import java.util.Date;

public abstract class Booking {
    protected int price;
    protected Event event;
    protected boolean optionToResell;
    protected Date expirationDate;
    protected Date bookingDate;
    protected boolean hasInvitedFriends;
}
