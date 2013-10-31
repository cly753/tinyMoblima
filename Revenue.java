package Moblima;

class Revenue {
    public static void getDailyCineplexRevenue(Cineplex currentCineplex, Time day) {
        LinkedList<Moviegoer> goerList= goerLib.getGoerList();
        Cinema[] currentCinema = currentCineplex.getCinemaList();
        int numOfCinema = currentCinema.length;
        ArrayList<ArrayList<Ticket>> revenueOfCinema = new ArrayList<ArrayList<Ticket>>();
        
        for (int i = 0; i < numOfCinema; i++) {
            ArrayList<Ticket> newCinema= new ArrayList<Ticket>();
            revenueOfCinema.add(newCinema);
        }
        
        for (i = 0; i < numOfCinema; i++) {
            for (Moviegoer goer : goerList) {
                ArrayList<Ticket> ticketList = goer.getPaidTicket();
                for (Ticket paidTicket : ticketList) {
                    if (paidTicket.getNameOfCinema() == currentCinema[i].getNameOfCinema
                        && paidTicket.getPayTime().getMonth() == day.getMonth()
                        && paidTicket.getPayTime().getDay() == day.getDay()) {
                        revenueOfCinema.get(i).add(paidTicket);
                    }
                }
            }
        }
        
        for (i = 0; i < numOfCinema; i++) {
            int sumCinemaTicketPrice = 0;
            for (Ticket paidTicket : revenueOfCinema.get(i)) {
                sumCinemaTicketPrice += paidTicket.getPrice();
            }
            System.out.println(currentCinema[i].getNameOfCinema() + " ticket sale : " + sumCinemaTicketPrice);
        }
    }
    
    
    public static void getMonthlyCineplexRevenue(Cineplex currentCineplex, Time day) {
        LinkedList<Moviegoer> goerList= goerLib.getGoerList();
        Cinema[] currentCinema = currentCineplex.getCinemaList();
        int numOfCinema = currentCinema.length;
        ArrayList<ArrayList<Ticket>> revenueOfCinema = new ArrayList<ArrayList<Ticket>>();
        
        for (int i = 0; i < numOfCinema; i++) {
            ArrayList<Ticket> newCinema= new ArrayList<Ticket>();
            revenueOfCinema.add(newCinema);
        }
        
        for (i = 0; i < numOfCinema; i++) {
            for (Moviegoer goer : goerList) {
                ArrayList<Ticket> ticketList = goer.getPaidTicket();
                for (Ticket paidTicket : ticketList) {
                    if (paidTicket.getNameOfCinema() == currentCinema[i].getNameOfCinema
                        && paidTicket.getPayTime().getMonth() == day.getMonth()) {
                        revenueOfCinema.get(i).add(paidTicket);
                    }
                }
            }
        }
        
        for (i = 0; i < numOfCinema; i++) {
            int sumCinemaTicketPrice = 0;
            for (Ticket paidTicket : revenueOfCinema.get(i)) {
                sumCinemaTicketPrice += paidTicket.getPrice();
            }
            System.out.println(currentCinema[i].getNameOfCinema() + " ticket sale : " + sumCinemaTicketPrice);
        }
    }
    
    public static void getDailyTotalRevenue(Time day) {
        LinkedList<Moviegoer> goerList= goerLib.getGoerList();
        int numOfCinema = 0;
        ArrayList<Ticket> revenueOfCinema = new <ArrayList<Ticket>();
        for (i = 0; i < numOfCinema; i++) {
            for (Moviegoer goer : goerList) {
                ArrayList<Ticket> ticketList = goer.getPaidTicket();
                for (Ticket paidTicket : ticketList) {
                    if (paidTicket.getPayTime().getMonth() == day.getMonth()
                        && paidTicket.getPayTime().getDay() == day.getDay()) {
                        revenueOfCinema.add(paidTicket);
                    }
                }
            }
        }
        
        int sumTotalTicketPrice = 0;
        for (Ticket paidTicket : revenueOfCinema) {
            sumCinemaTicketPrice += paidTicket.getPrice();
        }
        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
    }
    public static void getMonthlyTotalRevenue(Time day) {
            LinkedList<Moviegoer> goerList= goerLib.getGoerList();
        int numOfCinema = 0;
        ArrayList<Ticket> revenueOfCinema = new <ArrayList<Ticket>();
        for (i = 0; i < numOfCinema; i++) {
            for (Moviegoer goer : goerList) {
                ArrayList<Ticket> ticketList = goer.getPaidTicket();
                for (Ticket paidTicket : ticketList) {
                    if (paidTicket.getPayTime().getMonth() == day.getMonth()) {
                        revenueOfCinema.add(paidTicket);
                    }
                }
            }
        }
        int sumTotalTicketPrice = 0;
        for (Ticket paidTicket : revenueOfCinema) {
            sumCinemaTicketPrice += paidTicket.getPrice();
        }
        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
    }
    public static void getTotalRevenue() {
        LinkedList<Moviegoer> goerList= goerLib.getGoerList();
        ArrayList<Ticket> revenueOfCinema = new <ArrayList<Ticket>();
        for (Moviegoer goer : goerList) {
            ArrayList<Ticket> ticketList = goer.getPaidTicket();
            for (Ticket paidTicket : ticketList) {
                revenueOfCinema.add(paidTicket);
            }
        }
        int sumTotalTicketPrice = 0;
        for (Ticket paidTicket : revenueOfCinema) {
            sumCinemaTicketPrice += paidTicket.getPrice();
        }
        System.out.println("Total ticket sale : " + sumTotalTicketPrice);
    }
}
