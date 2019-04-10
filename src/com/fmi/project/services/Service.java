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
    private static Client[] clients = new Client[4];
    private static Event[] events = new Event[3];
    private static Location[] locations = new Location[2];
    private static Booking[] bookings = new Booking[4];

    private Service() {
        locations[0] = new LocateSeat(false, "La Costa", "Online", true, "Bucharest", 10, true);
        locations[1] = new LocateRegion(false, "Crazy Beach", "Online", true, "Constanta", "backstage");
        events[0] = new PublicEvent(locations[0], new Date(), new Date(2019, 2, 30), false, "New Year's Eve", "La Costa Restaurant", "Kony Band", "300 lei - 1 seara");
        events[1] = new PrivateEvent();
        events[2] = new PublicEvent(locations[1], new Date(), new Date(2019, 3, 21), false, "Sun Waves Party", "SunFest", "Arion", "350 lei - early bird pass");
        bookings[0] = new Reservation(103, events[0], true, new Date(2019, 2, 29), new Date(), true, false, 5, true);
        bookings[1] = new Ticket();
        bookings[2] = new FestivalPass();
        bookings[3] = new Reservation();
        clients[0] = new Individual();
        clients[1] = new Group();
        clients[2] = new Agency();
        clients[3] = new Individual();

        for(int i = 0; i < 4; i++) {
            clientsList.add(clients[i]);
        }
        for(int i = 0; i < 3; i++) {
            eventVector.add(events[i]);
        }
        Collections.sort(clientsList);
        Collections.sort(eventVector);

    }

    public static Service getInstance() {
        return instance;
    }

    public int howManyRewardsClaimed() {
        int no = 0;
        for(int i = 0; i < clients.length; i++) {
            if(clients[i] != null && clients[i] instanceof Individual) {
                no += ((Individual) clients[i]).getRewardsClaimed();
            }
        }
        return no;
    }

    public int howManyFreeEvents() {
        int number = 0;
        for(int i = 0; i < events.length; i++) {
            if(events[i].isFree())
                number += 1;
        }
        return number;
    }

    public boolean isThereAnyEventAtLaCosta() {
        for(int i = 0; i < locations.length; i++) {
            if(locations[i].getPlaceName().equals("La Costa"))
                return true;
        }
        return false;
    }

    public int howManyAgenciesWork() {
        int no = 0;
        for(int i = 0; i < clients.length; i++) {
            if(clients[i] != null && clients[i] instanceof Agency) {
                no += 1;
            }
        }
        return no;
    }

    public boolean doesAnyEventAcceptOnlineBooking() {
        for(int i = 0; i < locations.length; i++) {
            if(locations[i].isAcceptsBooking() && locations[i].getMeansOfBooking() == "online")
                return true;
        }
        return false;
    }

    public String latestEventFinish() {
        int index = 0;
        for(int i = 0; i < events.length - 1; i++) {
            if(events[i].getEndEvent().after(events[i + 1].getEndEvent()))
                index = i;
            else
                index = i + 1;
        }
        return events[index].getEventName() + " finishing on " + events[index].getEndEvent();
    }

    public int totalPricePaid() {
        int total = 0;
        for(int i = 0; i < clients.length; i++) {
            total += clients[i].getPricePaid();
        }
        return total;
    }

    public int howManyBookinsWithFriendsInvited() {
        int no = 0;
        for(int i = 0; i < bookings.length; i++) {
            if(bookings[i].isHasInvitedFriends())
                no++;
        }
        return no;
    }

    public void printClientsSortedBySumPaid() {
        for(Client client: clientsList) {
            System.out.println(client.getPricePaid());
        }
    }

    public void printEventsSortedByStartDate() {
        for(Event event: eventVector) {
            System.out.println(event.getStartEvent());
        }
    }

}
