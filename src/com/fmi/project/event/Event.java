package com.fmi.project.event;
import com.fmi.project.location.*;

import java.util.Date;

public abstract class Event implements Comparable<Event>{

    protected Location location;
    protected Date startEvent;
    protected Date endEvent;
    protected boolean isFree;
    protected String eventName;

    public Event(Location location, Date startEvent, Date endEvent, boolean isFree, String eventName) {
        this.location = location;
        this.startEvent = startEvent;
        this.endEvent = endEvent;
        this.isFree = isFree;
        this.eventName = eventName;
    }

    public Event() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getStartEvent() {
        return startEvent;
    }

    public void setStartEvent(Date startEvent) {
        this.startEvent = startEvent;
    }

    public Date getEndEvent() {
        return endEvent;
    }

    public void setEndEvent(Date endEvent) {
        this.endEvent = endEvent;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public int compareTo(Event ev) {
        return this.getStartEvent().compareTo(ev.startEvent);
    }
}
