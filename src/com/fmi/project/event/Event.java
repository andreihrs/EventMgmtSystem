package com.fmi.project.event;
import com.fmi.project.client.*;

import java.util.Date;

public abstract class Event implements Comparable<Event>{

    protected Client client;
    protected Date startEvent;
    protected String eventName;
    protected boolean isFree;

    public Event(Client client, Date startEvent, String eventName, boolean isFree) {
        this.client = client;
        this.startEvent = startEvent;
        this.eventName = eventName;
        this.isFree = isFree;
    }

    public Event() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getStartEvent() {
        return startEvent;
    }

    public void setStartEvent(Date startEvent) {
        this.startEvent = startEvent;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public boolean isFree() {return isFree;}

    public void setFree(boolean isFree) { this.isFree = isFree; }

    @Override
    public int compareTo(Event ev) {
        return this.getStartEvent().compareTo(ev.startEvent);
    }
}
