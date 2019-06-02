package com.fmi.project.event;

import com.fmi.project.client.Client;

import java.util.Date;

public class PublicEvent extends Event {

    private String specialGuest;

    public PublicEvent(Client client, Date startEvent, String eventName, boolean isFree, String specialGuest) {
        super(client, startEvent, eventName, isFree);
        this.specialGuest = specialGuest;
    }

    public PublicEvent(String specialGuest) {
        this.specialGuest = specialGuest;
    }

    public PublicEvent() {
    }

    public String getSpecialGuest() {
        return specialGuest;
    }

    public void setSpecialGuest(String specialGuest) {
        this.specialGuest = specialGuest;
    }

}
