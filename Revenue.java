package Moblima;

import java.util.*;

class Revenue {

    public static void getDailyCineplexRevenue(MoviegoerLib goerLib, Cineplex currentCineplex, Time day) {
        LinkedList<Moviegoer> goerList = goerLib.get();
        ArrayList<Cinema> currentCinema = currentCineplex.get();
        int numOfCinema = currentCinema.size();
        ArrayList<ArrayList<Ticket>> revenueOfCinema = new ArrayList<ArrayList<Ticket>>();

        for (int i = 0; i < numOfCinema; i++) {
            ArrayList<Ticket> newCinema = new ArrayList<Ticket>();
            revenueOfCinema.add(newCinema);
        }

        for (int i = 0; i < numOfCinema; i++) {
            for (Moviegoer goer : goerList) {
                ArrayList<Ticket> ticketList = goer.getPaid();
                for (Ticket paidTicket : ticketList) {
                    if (paidTicket.getNameOfCinema() == currentCinema.get(i).getNameOfCinema()
                            && paidTicket.getBuyTime().getMonth() == day.getMonth()
                            && paidTicket.getBuyTime().getDay() == day.getDay()) {
                        revenueOfCinema.get(i).add(paidTicket);
                    }
                }
            }
        }

        for (int i = 0; i < numOfCinema; i++) {
            int sumCinemaTicketPrice = 0;
            for (Ticket paidTicket : revenueOfCinema.get(i)) {
                sumCinemaTicketPrice += paidTicket.getPrice();
            }
            System.out.println(currentCinema.get(i).getNameOfCinema() + " ticket sale : " + sumCinemaTicketPrice);
        }
    }

    public static void getMonthlyCineplexRevenue(MoviegoerLib goerLib, Cineplex currentCineplex, Time day) {
        LinkedList<Moviegoer> goerList = goerLib.get();
        ArrayList<Cinema> currentCinema = currentCineplex.get();
        int numOfCinema = currentCinema.size();
        ArrayList<ArrayList<Ticket>> revenueOfCinema = new ArrayList<ArrayList<Ticket>>();

        for (int i = 0; i < numOfCinema; i++) {
            ArrayList<Ticket> newCinema = new ArrayList<Ticket>();
            revenueOfCinema.add(newCinema);
        }

        for (int i = 0; i < numOfCinema; i++) {
            for (Moviegoer goer : goerList) {
                ArrayList<Ticket> ticketList = goer.getPaid();
                for (Ticket paidTicket : ticketList) {
                    if (paidTicket.getNameOfCinema() == currentCinema.get(i).getNameOfCinema()
                            && paidTicket.getBuyTime().getMonth() == day.getMonth()) {
                        revenueOfCinema.get(i).add(paidTicket);
                    }
                }
            }
        }

        for (int i = 0; i < numOfCinema; i++) {
            int sumCinemaTicketPrice = 0;
            for (Ticket paidTicket : revenueOfCinema.get(i)) {
                sumCinemaTicketPrice += paidTicket.getPrice();
            }
            System.out.println(currentCinema.get(i).getNameOfCinema() + " ticket sale : " + sumCinemaTicketPrice);
        }
    }

    public static void getDailyTotalRevenue(MoviegoerLib goerLib, Time day) {
        LinkedList<Moviegoer> goerList = goerLib.get();
        int numOfCinema = 0;
        ArrayList<Ticket> revenueOfCinema = new ArrayList<Ticket>();
        for (int i = 0; i < numOfCinema; i++) {
            for (Moviegoer goer : goerList) {
                ArrayList<Ticket> ticketList = goer.getPaid();
                for (Ticket paidTicket : ticketList) {
                    if (paidTicket.getBuyTime().getMonth() == day.getMonth()
                            && paidTicket.getBuyTime().getDay() == day.getDay()) {
                        revenueOfCinema.add(paidTicket);
                    }
                }
            }
        }

        int sumTotalTicketPrice = 0;
        for (Ticket paidTicket : revenueOfCinema) {
            sumTotalTicketPrice += paidTicket.getPrice();
        }
        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
    }

    public static void getMonthlyTotalRevenue(MoviegoerLib goerLib, Time day) {
        LinkedList<Moviegoer> goerList = goerLib.get();
        int numOfCinema = 0;
        ArrayList<Ticket> revenueOfCinema = new ArrayList<Ticket>();
        for (int i = 0; i < numOfCinema; i++) {
            for (Moviegoer goer : goerList) {
                ArrayList<Ticket> ticketList = goer.getPaid();
                for (Ticket paidTicket : ticketList) {
                    if (paidTicket.getBuyTime().getMonth() == day.getMonth()) {
                        revenueOfCinema.add(paidTicket);
                    }
                }
            }
        }
        int sumTotalTicketPrice = 0;
        for (Ticket paidTicket : revenueOfCinema) {
            sumTotalTicketPrice += paidTicket.getPrice();
        }
        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
    }

    public static void getTotalRevenue(MoviegoerLib goerLib) {
        LinkedList<Moviegoer> goerList = goerLib.get();
        ArrayList<Ticket> revenueOfCinema = new ArrayList<Ticket>();
        for (Moviegoer goer : goerList) {
            ArrayList<Ticket> ticketList = goer.getPaid();
            for (Ticket paidTicket : ticketList) {
                revenueOfCinema.add(paidTicket);
            }
        }
        int sumTotalTicketPrice = 0;
        for (Ticket paidTicket : revenueOfCinema) {
            sumTotalTicketPrice += paidTicket.getPrice();
        }
        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
    }
}
