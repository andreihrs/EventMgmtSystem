package com.fmi.project.services;

import com.fmi.project.client.*;
import com.fmi.project.event.*;
import com.fmi.project.location.*;
import com.fmi.project.booking.*;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class Service {

    private static List <Client> clientsList = new ArrayList<>();
    private static Vector<Event> eventVector = new Vector<>();
    private static Client[] clients = new Client[13];
    private static Event[] events = new Event[13];
    private static Location[] locations = new Location[3];
    private static Booking[] bookings = new Booking[4];
    private static final Service instance = new Service();

    private Service() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao?serverTimezone=UTC", "root", "Andrei123");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from agency");

            ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
            int i = 0;
            while (resultSet.next()) {
                int pr, nob;
                boolean ftc;
                String els, cn;
                if(resultSet.getInt(3) == 0)
                    ftc = false;
                else
                    ftc = true;
                pr = resultSet.getInt(2);
                nob = resultSet.getInt(5);
                els = resultSet.getString(4);
                cn = resultSet.getString(6);

                clients[i] = new Agency(pr, ftc, els, nob, cn);
                i++;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao?serverTimezone=UTC", "root", "Andrei123");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from individual");

            ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
            int i = 2;
            while (resultSet.next()) {
                int pr, pc, cu, rc;
                boolean ftc;
                String els;
                if(resultSet.getInt(3) == 0)
                    ftc = false;
                else
                    ftc = true;
                pr = resultSet.getInt(2);
                pc = resultSet.getInt(5);
                els = resultSet.getString(4);
                cu = resultSet.getInt(6);
                rc = resultSet.getInt(7);

                clients[i] = new Individual(pr, ftc, els, pc, cu, rc);
                i++;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao?serverTimezone=UTC", "root", "Andrei123");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from proiectpao.group");

            ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
            int i = 4;
            while (resultSet.next()) {
                int pr, nop;
                boolean ftc, efr;
                String els;
                if(resultSet.getInt(3) == 0)
                    ftc = false;
                else
                    ftc = true;

                if(resultSet.getInt(6) == 0)
                    efr = false;
                else
                    efr = true;
                pr = resultSet.getInt(2);
                nop = resultSet.getInt(5);
                els = resultSet.getString(4);

                clients[i] = new Group(pr, ftc, els, nop, efr);
                i++;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        locations[0] = new LocateSeat(false, "La Costa", "Online", true, "Bucharest", 10, true);
        locations[1] = new LocateRegion(true, "Crazy Beach", "Online", true, "Constanta", "backstage");
        locations[2] = new LocateRegion(true, "Crazy Beach", "Online", true, "Constanta", "backstage");
        bookings[0] = new Reservation(103, events[0], false, new Date(2019, 5, 29), new Date(), true, false, 5, true);
        bookings[1] = new Ticket(250, events[2], true, new Date(2019, 6, 30), new Date(), true, false, true, true, 300, "No");
        bookings[2] = new FestivalPass(450, events[1], true, new Date(2019, 7, 2), new Date(), true, false, true, true, 300, "Yes", 3, "nr1", false);
        bookings[3] = new Reservation(145, events[0], false, new Date(2019, 6, 31), new Date(), false, true, 10, true);
        clients[6] = new Individual(110, true, "1st Time Customers", 0, 0, 1);
        clients[7] = new Group(1750, true, "Group attendes", 7, true);
        clients[8] = new Agency(900, false, "Partners", 34, "Fractalize");
        clients[9] = new Individual(145, false, "Vegan Customers", 5, 2, 1);
        clients[10] = FileTextServiceIndividual.getInstance().readIndividualFromFile("files/individual.csv");
        clients[11] = FileTextServiceGroup.getInstance().readGroupFromFile("files/group.csv");
        clients[12] = FileTextServiceAgency.getInstance().readAgencyFromFile("files/agency.csv");
        locations[0] = FileTextServiceLocateSeat.getInstance().readLocateSeatFromFile("files/locateseat.csv");

        events[0] = new PublicEvent(clients[0], new Date(), "New Year's Eve", true, "Kony Band");
        events[1] = new PrivateEvent(clients[1], new Date(2019, 4, 23), "SW Festival", false, true);
        events[2] = new PublicEvent(clients[2], new Date(2019, 5, 18), "Sun Waves Party", false, "Arion");
        events[3] = new PublicEvent(clients[3], new Date(2019, 8, 13), "Vienna orchestra", false, "Johan Johansson");
        events[4] = new PrivateEvent(clients[4], new Date(2019, 4, 23), "Toastmasters Public Speaking", true, true);
        events[5] = new PublicEvent(clients[5], new Date(2019, 12, 22), "Christmas Party", false, "Hans Zimmer");
        events[6] = new PrivateEvent(clients[6], new Date(2019, 7, 23), "Networking event", true, false);
        events[7] = new PublicEvent(clients[7], new Date(2019, 10, 12), "Lasata Secului", false, "Vali vijelie");
        events[8] = new PrivateEvent(clients[8], new Date(2019, 9, 23), "Bucharest summer festival", true, false);
        events[9] = new PublicEvent(clients[9], new Date(2019, 6, 29), "Downtown bucharest", true, "Bucharest Symphony");
        events[10] = new PrivateEvent(clients[10], new Date(2019, 7, 03), "Books & music", true, true);
        events[11] = new PublicEvent(clients[11], new Date(2019, 8, 04), "SummerLand", false, "Son Lux");
        events[12] = new PrivateEvent(clients[12], new Date(2019, 6, 31), "SW Festival 2", false, false);

        for(int i = 0; i < 13; i++) {
            clientsList.add(clients[i]);
        }
        for(int i = 0; i < 13; i++) {
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
                append(",").append(new Timestamp(System.currentTimeMillis())).append(",")
                .append(Thread.currentThread().getName());
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
                append(",").append(new Timestamp(System.currentTimeMillis())).append(",")
                .append(Thread.currentThread().getName());
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
                append(",").append(new Timestamp(System.currentTimeMillis())).append(",")
                .append(Thread.currentThread().getName());
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
                append(",").append(new Timestamp(System.currentTimeMillis())).append(",")
                .append(Thread.currentThread().getName());
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
                append(",").append(new Timestamp(System.currentTimeMillis())).append(",")
                .append(Thread.currentThread().getName());
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        for(int i = 0; i < locations.length; i++) {
            if(locations[i].isAcceptsBooking() && locations[i].getMeansOfBooking() == "online")
                return true;
        }
        return false;
    }

//    public String latestEventFinish() {
//        StringBuilder stringBuilder = new StringBuilder("");
//        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
//                append(",").append(new Timestamp(System.currentTimeMillis())).append(",")
//                .append(Thread.currentThread().getName());
//        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
//                "files/times.csv");
//        int index = 0;
//        for(int i = 0; i < events.length - 1; i++) {
//            if(events[i].getEndEvent().after(events[i + 1].getEndEvent()))
//                index = i;
//            else
//                index = i + 1;
//        }
//        return events[index].getEventName() + " finishing on " + events[index].getEndEvent();
//    }

    public int totalPricePaid() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis())).append(",")
                .append(Thread.currentThread().getName());
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
                append(",").append(new Timestamp(System.currentTimeMillis())).append(",")
                .append(Thread.currentThread().getName());
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        int no = 0;
        for(int i = 0; i < bookings.length; i++) {
            if(bookings[i].isHasInvitedFriends())
                no++;
        }
        return no;
    }

    public List<Client> clientsWhoGoToEventsAfterSummer(){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object() {
        }.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()))
                .append(Thread.currentThread().getName());
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        List<Client> clientsWhoGoToEventsAfterSummer = new ArrayList<>();
        for (int i = 0; i < events.length; i++)
            if (events[i].getStartEvent().after(new Date(2019, 8, 31))) {
                clientsWhoGoToEventsAfterSummer.add(events[i].getClient());
            }
        return clientsWhoGoToEventsAfterSummer;
    }

    public List<Client> clientsWhoGoToFreeEvents(){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object() {
        }.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()))
                .append(Thread.currentThread().getName());
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        List<Client> clientsWhoGoToFreeEvents = new ArrayList<>();
        for (int i = 0; i < events.length; i++)
            if (events[i].isFree()) {
                clientsWhoGoToFreeEvents.add(events[i].getClient());
            }

        return clientsWhoGoToFreeEvents();
    }

    public List<Client> firstTimeCustomers(){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()))
                .append(Thread.currentThread().getName());
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        List<Client> firstTimeCustomers = new ArrayList<>();

        for (int i = 0; i < events.length; i++)
            if (events[i].getClient().isFirstTimeCustomer())
                firstTimeCustomers.add(events[i].getClient());
        return firstTimeCustomers;
    }

    public List<Client> clientsWhoSpentMoreThan100(){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()))
                .append(Thread.currentThread().getName());
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        List<Client> clientsWhoSpentMoreThan100 = new ArrayList<>();

        for (int i = 0; i < events.length; i++)
            if (events[i].getClient().getPricePaid() >= 100)
                clientsWhoSpentMoreThan100.add(events[i].getClient());
        return clientsWhoSpentMoreThan100;
    }

    public List<Location> locationsWhichAreFull(){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()))
                .append(Thread.currentThread().getName());
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        List<Location> locationsWhichAreFull = new ArrayList<>();

        for (int i = 0; i < events.length; i++)
            if (locations[i].isFull())
                locationsWhichAreFull.add(locations[i]);
        return locationsWhichAreFull;
    }

    public void printClientsSortedBySumPaid() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis())).append(",")
                .append(Thread.currentThread().getName());
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        for(Client client: clientsList) {
            System.out.println(client.getPricePaid());
        }
    }

    public void printEventsSortedByStartDate() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis())).append(",")
                .append(Thread.currentThread().getName());
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
        for(Event event: eventVector) {
            System.out.println(event.getStartEvent());
        }
    }

}
