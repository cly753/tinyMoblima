package Moblima;

import java.util.*;

class Revenue {
    
    //old one
//    public static void getDailyCineplexRevenue(MoviegoerLib goerLib, Cineplex currentCineplex, Time day) {
//        LinkedList<Moviegoer> goerList = goerLib.get();
//        ArrayList<Cinema> currentCinema = currentCineplex.get();
//        int numOfCinema = currentCinema.size();
//        ArrayList<ArrayList<Ticket>> revenueOfCinema = new ArrayList<ArrayList<Ticket>>();
//        
//        for (int i = 0; i < numOfCinema; i++) {
//            ArrayList<Ticket> newCinema = new ArrayList<Ticket>();
//            revenueOfCinema.add(newCinema);
//        }
//
//        for (int i = 0; i < numOfCinema; i++) {
//            for (Moviegoer goer : goerList) {
//                ArrayList<Ticket> ticketList = goer.getPaid();
//                for (Ticket paidTicket : ticketList) {
//                    if (paidTicket.getCinemaID() == currentCinema.get(i).getCinemaID()
//                            && paidTicket.getBuyTime().getMonth() == day.getMonth()
//                            && paidTicket.getBuyTime().getDay() == day.getDay()) {
//                        revenueOfCinema.get(i).add(paidTicket);
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < numOfCinema; i++) {
//            int sumCinemaTicketPrice = 0;
//            for (Ticket paidTicket : revenueOfCinema.get(i)) {
//                sumCinemaTicketPrice += paidTicket.getPrice();
//            }
//            System.out.println(currentCinema.get(i).getCinemaID() + " ticket sale : " + sumCinemaTicketPrice);
//        }
//    }

    //new one
    public static void getDailyCineplexRevenue(TicketLib tiLib, Cineplex currentCineplex, Time day) {
        int numOfTicket = tiLib.getNumOfTicket();
        ArrayList<Cinema> currentCinema = currentCineplex.get();
        int numOfCinema = currentCinema.size();
        ArrayList<ArrayList<Ticket>> revenueOfCinema = new ArrayList<ArrayList<Ticket>>();
        
        for (int i = 0; i < numOfCinema; i++) {
            ArrayList<Ticket> newCinema = new ArrayList<Ticket>();
            revenueOfCinema.add(newCinema);
        }
        for (int i = 0; i < numOfCinema; i++) {
            for (int index = 0; index < numOfTicket; index++) {
                Ticket paidTicket = tiLib.searchTicketByID(index);
                if (paidTicket.getCinemaID() == currentCinema.get(i).getCinemaID()
                    && paidTicket.getBuyTime().getMonth() == day.getMonth()
                    && paidTicket.getBuyTime().getDay() == day.getDay()) {
                    revenueOfCinema.get(i).add(paidTicket);
                }
            }
        }
        for (int i = 0; i < numOfCinema; i++) {
            int sumCinemaTicketPrice = 0;
            for (Ticket paidTicket : revenueOfCinema.get(i)) {
                sumCinemaTicketPrice += paidTicket.getPrice();
            }
            System.out.println(currentCinema.get(i).getCinemaID() + " ticket sale : " + sumCinemaTicketPrice);
        }
    }
    
    //old one
//    public static void getMonthlyCineplexRevenue(MoviegoerLib goerLib, Cineplex currentCineplex, Time day) {
//        LinkedList<Moviegoer> goerList = goerLib.get();
//        ArrayList<Cinema> currentCinema = currentCineplex.get();
//        int numOfCinema = currentCinema.size();
//        ArrayList<ArrayList<Ticket>> revenueOfCinema = new ArrayList<ArrayList<Ticket>>();
//
//        for (int i = 0; i < numOfCinema; i++) {
//            ArrayList<Ticket> newCinema = new ArrayList<Ticket>();
//            revenueOfCinema.add(newCinema);
//        }
//
//        for (int i = 0; i < numOfCinema; i++) {
//            for (Moviegoer goer : goerList) {
//                ArrayList<Ticket> ticketList = goer.getPaid();
//                for (Ticket paidTicket : ticketList) {
//                    if (paidTicket.getCinemaID() == currentCinema.get(i).getCinemaID()
//                            && paidTicket.getBuyTime().getMonth() == day.getMonth()) {
//                        revenueOfCinema.get(i).add(paidTicket);
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < numOfCinema; i++) {
//            int sumCinemaTicketPrice = 0;
//            for (Ticket paidTicket : revenueOfCinema.get(i)) {
//                sumCinemaTicketPrice += paidTicket.getPrice();
//            }
//            System.out.println(currentCinema.get(i).getCinemaID() + " ticket sale : " + sumCinemaTicketPrice);
//        }
//    }

    public static void getMonthlyCineplexRevenue(TicketLib tiLib, Cineplex currentCineplex, Time day) {
        int numOfTicket = tiLib.size();
        ArrayList<Cinema> currentCinema = currentCineplex.get();
        int numOfCinema = currentCinema.size();
        ArrayList<ArrayList<Ticket>> revenueOfCinema = new ArrayList<ArrayList<Ticket>>();
        
        for (int i = 0; i < numOfCinema; i++) {
            ArrayList<Ticket> newCinema = new ArrayList<Ticket>();
            revenueOfCinema.add(newCinema);
        }
        for (int i = 0; i < numOfCinema; i++) {
            for (int index = 0; index < numOfTicket; index++) {
                Ticket paidTicket = tiLib.get(index);
                if (paidTicket.getCinemaID() == currentCinema.get(i).getCinemaID()
                    && paidTicket.getBuyTime().getMonth() == day.getMonth()) {
                    revenueOfCinema.get(i).add(paidTicket);
                }
            }
        }
        for (int i = 0; i < numOfCinema; i++) {
            int sumCinemaTicketPrice = 0;
            for (Ticket paidTicket : revenueOfCinema.get(i)) {
                sumCinemaTicketPrice += paidTicket.getPrice();
            }
            System.out.println(currentCinema.get(i).getCinemaID() + " ticket sale : " + sumCinemaTicketPrice);
        }
    }
    
//    public static void getDailyTotalRevenue(MoviegoerLib goerLib, Time day) {
//        LinkedList<Moviegoer> goerList = goerLib.get();
//        int numOfCinema = 0;
//        ArrayList<Ticket> revenueOfCinema = new ArrayList<Ticket>();
//        for (int i = 0; i < numOfCinema; i++) {
//            for (Moviegoer goer : goerList) {
//                ArrayList<Ticket> ticketList = goer.getPaid();
//                for (Ticket paidTicket : ticketList) {
//                    if (paidTicket.getBuyTime().getMonth() == day.getMonth()
//                            && paidTicket.getBuyTime().getDay() == day.getDay()) {
//                        revenueOfCinema.add(paidTicket);
//                    }
//                }
//            }
//        }
//
//        int sumTotalTicketPrice = 0;
//        for (Ticket paidTicket : revenueOfCinema) {
//            sumTotalTicketPrice += paidTicket.getPrice();
//        }
//        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
//    }

    public static void getDailyTotalRevenue(TicketLib tiLib, Time day) {
        ArrayList<Ticket> revenueOfCinema = new ArrayList<Ticket>();
        int numOfTicket = tiLib.size();
    
        for (int index = 0; index < numOfTicket; index++) {
            Ticket paidTicket = tiLib.get(index);
            if ((paidTicket.getBuyTime().getMonth() == day.getMonth())
                && paidTicket.getBuyTime().getDay() == day.getDay()) {
            revenueOfCinema.add(paidTicket);
            }
        }
        
        int sumTotalTicketPrice = 0;
        for (Ticket paidTicket : revenueOfCinema) {
            sumTotalTicketPrice += paidTicket.getPrice();
        }
        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
    }
    
//    public static void getMonthlyTotalRevenue(MoviegoerLib goerLib, Time day) {
//        LinkedList<Moviegoer> goerList = goerLib.get();
//        int numOfCinema = 0;
//        ArrayList<Ticket> revenueOfCinema = new ArrayList<Ticket>();
//        for (int i = 0; i < numOfCinema; i++) {
//            for (Moviegoer goer : goerList) {
//                ArrayList<Ticket> ticketList = goer.getPaid();
//                for (Ticket paidTicket : ticketList) {
//                    if (paidTicket.getBuyTime().getMonth() == day.getMonth()) {
//                        revenueOfCinema.add(paidTicket);
//                    }
//                }
//            }
//        }
//        int sumTotalTicketPrice = 0;
//        for (Ticket paidTicket : revenueOfCinema) {
//            sumTotalTicketPrice += paidTicket.getPrice();
//        }
//        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
//    }

    public static void getMonthlyTotalRevenue(TicketLib tiLib, Time day) {
        ArrayList<Ticket> revenueOfCinema = new ArrayList<Ticket>();
        int numOfTicket = tiLib.getNumOfTicket();
    
        for (int index = 0; index < numOfTicket; index++) {
            Ticket paidTicket = tiLib.get(index);
            if (paidTicket.getBuyTime().getMonth() == day.getMonth()) {
                revenueOfCinema.add(paidTicket);
            }
        }
        
        int sumTotalTicketPrice = 0;
        for (Ticket paidTicket : revenueOfCinema) {
            sumTotalTicketPrice += paidTicket.getPrice();
        }
        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
    }
    
//    public static void getTotalRevenue(MoviegoerLib goerLib) {
//        LinkedList<Moviegoer> goerList = goerLib.get();
//        ArrayList<Ticket> revenueOfCinema = new ArrayList<Ticket>();
//        for (Moviegoer goer : goerList) {
//            ArrayList<Ticket> ticketList = goer.getPaid();
//            for (Ticket paidTicket : ticketList) {
//                revenueOfCinema.add(paidTicket);
//            }
//        }
//        int sumTotalTicketPrice = 0;
//        for (Ticket paidTicket : revenueOfCinema) {
//            sumTotalTicketPrice += paidTicket.getPrice();
//        }
//        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
//    }
    
    public static void getTotalRevenue(TicketLib tiLib) {
        int numOfTicket = tiLib.getNumOfTicket();
        int sumTotalTicketPrice = 0;
        for (int index = 0; index < numOfTicket; index++) {
            Ticket paidTicket = tiLib.get(index);
            sumTotalTicketPrice += paidTicket.getPrice();
        }
        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
    }
}
