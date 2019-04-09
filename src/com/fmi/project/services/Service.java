package com.fmi.project.services;

import com.fmi.project.client.*;
import com.fmi.project.event.*;
import com.fmi.project.location.*;
import com.fmi.project.booking.*;

import java.util.*;

public class Service {

    private static final Service instance = new Service();
    private static List <Client> clientsList = new ArrayList<>();
    private static Vector <Event> eventVector = new Vector<>();
    private static Client[] clients = new Client[8];
    private static Event[] events = new Event[4];
    private static Location[] locations = new Location[2];
    private static Booking[] bookings = new Booking[8];

    private Service() {
        locations[0] = new LocateSeat(false, 10, "La Costa", "Online", true, "Bucharest", 10, true);
        bookings[0] = new Reservation();
        clients[0] = new Individual();
        events[0] = new PublicEvent();
    }

    public static Service getInstance() {
        return instance;
    }

//    public Date whenIsFirstEvent() {
//
//    }

}
