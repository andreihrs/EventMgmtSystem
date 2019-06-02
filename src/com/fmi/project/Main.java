package com.fmi.project;

import com.fmi.project.services.Service;

public class Main {

    public static void main(String[] args) {
        System.out.println(Service.getInstance().howManyAgenciesWork());
        System.out.println(Service.getInstance().howManyBookingsWithFriendsInvited());
//        System.out.println(Service.getInstance().howManyFreeEvents());
        System.out.println(Service.getInstance().howManyRewardsClaimed());
        System.out.println(Service.getInstance().isThereAnyEventAtLaCosta());
//        System.out.println(Service.getInstance().latestEventFinish());
        System.out.println(Service.getInstance().doesAnyEventAcceptOnlineBooking());
        System.out.println(Service.getInstance().totalPricePaid());
        Service.getInstance().printClientsSortedBySumPaid();
        Service.getInstance().printEventsSortedByStartDate();
    }
}
