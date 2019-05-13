package com.fmi.project.services;

import com.fmi.project.client.*;
import com.fmi.project.event.*;
import com.fmi.project.location.*;
import com.fmi.project.booking.*;

import java.sql.Timestamp;
import java.util.*;

public class Service {

    private static List <Client> clientsList = new ArrayList<>();
    private static Vector<Event> eventVector = new Vector<>();
    private static Client[] clients = new Client[4];
    private static Event[] events = new Event[3];
    private static Location[] locations = new Location[2];
    private static Booking[] bookings = new Booking[4];
    private static final Service instance = new Service();

    private Service() {
        locations[0] = new LocateSeat(false, "La Costa", "Online", true, "Bucharest", 10, true);
        locations[1] = new LocateRegion(false, "Crazy Beach", "Online", true, "Constanta", "backstage");
        events[0] = new PublicEvent(locations[0], new Date(), new Date(2019, 4, 15), false, "New Year's Eve", "La Costa Restaurant", "Kony Band", "300 lei - 1 seara");
        events[1] = new PrivateEvent(locations[0], new Date(2019, 4, 23), new Date(2019, 4, 29), false, "SW Festival", false, true);
        events[2] = new PublicEvent(locations[1], new Date(2019, 5, 18), new Date(2019, 5, 21), false, "Sun Waves Party", "SunFest", "Arion", "350 lei - early bird pass");
        bookings[0] = new Reservation(103, events[0], false, new Date(2019, 5, 29), new Date(), true, false, 5, true);
        bookings[1] = new Ticket(250, events[2], true, new Date(2019, 6, 30), new Date(), true, false, true, true, 300, "No");
        bookings[2] = new FestivalPass(450, events[1], true, new Date(2019, 7, 2), new Date(), true, false, true, true, 300, "Yes", 3, "nr1", false);
        bookings[3] = new Reservation(145, events[0], false, new Date(2019, 6, 31), new Date(), false, true, 10, true);
        clients[0] = new Individual(true, false, 110, true, "1st Time Customers", 0, 0, 1);
        clients[1] = new Group(true, true, 1750, true, "Group attendes", 7, true, true);
        clients[2] = new Agency(true, false, 900, false, "Partners", 34, true, 15, "Fractalize");
        clients[3] = new Individual(true, true, 145, false, "Vegan Customers", 5, 2, 1);

        clients[0] = FileTextServiceIndividual.getInstance().readIndividualFromFile("files/individual.csv");
        clients[1] = FileTextServiceGroup.getInstance().readGroupFromFile("files/group.csv");
        clients[2] = FileTextServiceAgency.getInstance().readAgencyFromFile("files/agency.csv");
        locations[0] = FileTextServiceLocateSeat.getInstance().readLocateSeatFromFile("files/locateseat.csv");


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
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        int no = 0;
        for(int i = 0; i < clients.length; i++) {
            if(clients[i] != null && clients[i] instanceof Individual) {
                no += ((Individual) clients[i]).getRewardsClaimed();
            }
        }
        return no;
    }

    public int howManyFreeEvents() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        int number = 0;
        for(int i = 0; i < events.length; i++) {
            if(events[i].isFree())
                number += 1;
        }
        return number;
    }

    public boolean isThereAnyEventAtLaCosta() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        for(int i = 0; i < locations.length; i++) {
            if(locations[i].getPlaceName().equals("La Costa"))
                return true;
        }
        return false;
    }

    public int howManyAgenciesWork() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        int no = 0;
        for(int i = 0; i < clients.length; i++) {
            if(clients[i] != null && clients[i] instanceof Agency) {
                no += 1;
            }
        }
        return no;
    }

    public boolean doesAnyEventAcceptOnlineBooking() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        for(int i = 0; i < locations.length; i++) {
            if(locations[i].isAcceptsBooking() && locations[i].getMeansOfBooking() == "online")
                return true;
        }
        return false;
    }

    public String latestEventFinish() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
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
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        int total = 0;
        for(int i = 0; i < clients.length; i++) {
            total += clients[i].getPricePaid();
        }
        return total;
    }

    public int howManyBookingsWithFriendsInvited() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        int no = 0;
        for(int i = 0; i < bookings.length; i++) {
            if(bookings[i].isHasInvitedFriends())
                no++;
        }
        return no;
    }

    public void printClientsSortedBySumPaid() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        for(Client client: clientsList) {
            System.out.println(client.getPricePaid());
        }
    }

    public void printEventsSortedByStartDate() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        for(Event event: eventVector) {
            System.out.println(event.getStartEvent());
        }
    }

}
