package com.fmi.project.event;

import com.fmi.project.location.Location;

import java.util.Date;

public class PublicEvent extends Event {

    private String createdBy;
    private String specialGuest;
    private String specialOffer;

    public PublicEvent(Location location, Date startEvent, Date endEvent, boolean isFree, String eventName, String createdBy, String specialGuest, String specialOffer) {
        super(location, startEvent, endEvent, isFree, eventName);
        this.createdBy = createdBy;
        this.specialGuest = specialGuest;
        this.specialOffer = specialOffer;
    }

    public PublicEvent(String createdBy, String specialGuest, String specialOffer) {
        this.createdBy = createdBy;
        this.specialGuest = specialGuest;
        this.specialOffer = specialOffer;
    }

    public PublicEvent() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getSpecialGuest() {
        return specialGuest;
    }

    public void setSpecialGuest(String specialGuest) {
        this.specialGuest = specialGuest;
    }

    public String getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(String specialOffer) {
        this.specialOffer = specialOffer;
    }
}
