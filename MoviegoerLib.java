package Moblima;

import java.util.*;
import java.io.*;

class MoviegoerLib {

    private LinkedList<Moviegoer> goerLib;
    public static Scanner sc = new Scanner(System.in);

    public MoviegoerLib() {
        goerLib = new LinkedList<Moviegoer>();
    }

    public void load(String parentPath) throws IOException {
        String fileLocation = parentPath + "_MoviegoerLib.txt";
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(fileLocation));
            int size = Integer.parseInt(properties.getProperty("__size"));
            
            for (int i = 0; i < size; i++) {
                Moviegoer newGoer = new Moviegoer(null, null, null, null, null, 0);
                newGoer.setUsername(properties.getProperty(i + "_username"));
                newGoer.setPassword(properties.getProperty(i + "_password"));
                newGoer.setName(properties.getProperty(i + "_name"));
                newGoer.setMobileNumber(properties.getProperty(i + "_mobileNumber"));
                newGoer.setEmailAddress(properties.getProperty(i + "_emailAddress"));
                newGoer.setAge(Integer.parseInt(properties.getProperty(i + "_age")));
                int ticketSize = Integer.parseInt(properties.getProperty(i + "_numOfPaid"));
                for (int j = 0; j < ticketSize; j++)
                    newGoer.getPaid().add(Integer.parseInt(properties.getProperty(i + "_paid_" + j)));
                ticketSize = Integer.parseInt(properties.getProperty(i + "_numOfUnpaid"));
                for (int j = 0; j < ticketSize; j++)
                    newGoer.getUnpaid().add(Integer.parseInt(properties.getProperty(i + "_unpaid_" + j)));
                goerLib.add(newGoer);
            }
        } catch (Exception e) {
            File f = new File(parentPath, "_MoviegoerLib.txt"); // create if file is not there
            f.createNewFile();
            System.out.println("Unable to process " + fileLocation);
        }
    }

    public void store(String parentPath) throws IOException {
        String fileLocation = parentPath + "_MoviegoerLib.txt";
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(fileLocation));
            
            properties.setProperty("__size", Integer.toString(goerLib.size()));
            
            for (int i = 0; i < goerLib.size(); i++) {
                properties.setProperty(i + "_username", goerLib.get(i).getUsername());
                properties.setProperty(i + "_password", goerLib.get(i).getPassword());
                properties.setProperty(i + "_name", goerLib.get(i).getName());
                properties.setProperty(i + "_mobileNumber", goerLib.get(i).getMobileNumber());
                properties.setProperty(i + "_emailAddress", goerLib.get(i).getEmailAddress());
                properties.setProperty(i + "_age", goerLib.get(i).getAge().toString());
                properties.setProperty(i + "_numOfPaid", ((Integer)goerLib.get(i).getPaid().size()).toString());
                properties.setProperty(i + "_numOfUnpaid", ((Integer)goerLib.get(i).getUnpaid().size()).toString());
                for (int j = 0; j < goerLib.get(i).getPaid().size(); j++)
                    properties.setProperty(i + "_paid_" + j, (goerLib.get(i).getPaid().get(j)).toString());
                for (int j = 0; j < goerLib.get(i).getUnpaid().size(); j++)
                    properties.setProperty(i + "_unpaid_" + j, (goerLib.get(i).getUnpaid().get(j)).toString());
            }
            
            properties.store(new FileOutputStream(fileLocation), "");
        } catch (Exception e) {
        	File f = new File(parentPath, "_MoviegoerLib.txt");
			f.createNewFile();
            System.out.println("Unable to process " + fileLocation);
        }
    }

    public Moviegoer add() {

        System.out.println("username: ");
        String newUsername = sc.next();

        System.out.println("password: ");
        String newPassword = sc.next();

        sc.nextLine();
        System.out.println("name: ");
        String newName = sc.nextLine();

        System.out.println("mobile number: ");
        String newMobileNumber = sc.next();

        System.out.println("email address: ");
        String newEmailAddress = sc.next();

        System.out.println("age: ");
        Integer newAge = sc.nextInt();

        System.out.print("confirm? 1/0");
        Moviegoer newGoer;
        if (sc.nextInt() == 1) {
            newGoer = new Moviegoer(newUsername,
                                    newPassword,
                                    newName,
                                    newMobileNumber,
                                    newEmailAddress,
                                    newAge);
            goerLib.add(newGoer);
        } else {
            newGoer = null;
        }
        
        return newGoer;
    }

    public boolean delete(Moviegoer goer) {
        System.out.println("password: ");
        String tempPassword = sc.next();
        if (goer.getPassword().compareTo(tempPassword) == 0) {
            int i = goerLib.indexOf(goer);
            if (goerLib.indexOf(goer) != -1) {
                goerLib.remove(i);
                return true;
            }
        }

        return false;
    }

    public static boolean modify(Moviegoer goer, int choice) {

        switch (choice) {
            case 1:
                System.out.print("New name: ");
                goer.setName(sc.nextLine());
                break;
            case 2:
                System.out.print("New mobile number: ");
                goer.setMobileNumber(sc.next());
                break;
            case 3:
                System.out.print("New email address: ");
                goer.setEmailAddress(sc.next());
                break;
            case 4:
                System.out.print("New age: ");
                goer.setAge(sc.nextInt());
                break;
            default:
                System.out.println("invalid. again: ");
                return false;
        }
        return true;
    }

    public Moviegoer checkLogin(String nameTry, String pwdTry) {
        ListIterator<Moviegoer> iter = goerLib.listIterator(0);
        Moviegoer temp = null;
        while (iter.hasNext()) {
            temp = iter.next();
            if (temp.getUsername().compareTo(nameTry) == 0) {
                if (temp.getPassword().compareTo(pwdTry) == 0) {
                    return temp;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public static boolean pay(Moviegoer goer, TicketLib tiLib, int index) {
        Time tempTime = new Time();
        Integer ticketID;

        System.out.println("1.Visa 2.Master? ");
        sc.nextInt();

        ticketID = goer.getUnpaid().remove(index);
        tiLib.searchTicketByID(ticketID).setBuyTime(tempTime.getCurrentTime());
        goer.getPaid().add(ticketID);

        System.out.println("paid!");
        return true;
    }

    public static void showHistory(Moviegoer goer, TicketLib tiLib, boolean onlyUnpaid) {
        int unpaidSize = goer.getUnpaid().size();
        int paidSize = goer.getPaid().size();
        Integer ticketID;
        int pageSize = 5;

        for (int i = 0; i < unpaidSize; i++) {
            ticketID = goer.getUnpaid().get(i);

            Ticket.display(tiLib.searchTicketByID(ticketID));
            System.out.println(">" + (i + 1) + " Not paid");
        }
        if (onlyUnpaid) {
            return;
        }

        for (int i = 0; i < paidSize; i++) {
            ticketID = goer.getPaid().get(i);
            Ticket.display(tiLib.searchTicketByID(ticketID));
            System.out.print(">paid");

            if (--pageSize == 0 && i < paidSize - 1) {
                System.out.print(">Continue? 1/0");
                if (sc.nextInt() == 0) {
                    break;
                }
            }
            System.out.println();
        }
    }

    public static Ticket book(Moviegoer goer, Movie toBook, TicketLib tiLib, Company company) {
        Cinema cinema;

        System.out.println("Select a showtime");
        ArrayList<Session> sessionList = toBook.getSessionList(false);
        for (int i = 0; i < sessionList.size(); i++) {
            System.out.print("Session> " + (i + 1) + ": " + sessionList.get(i).getTime().getStr()
                    + " @Cinema" + sessionList.get(i).getCinema().getCinemaID() + "    \n");
        }
        
        System.out.println("Please input your choice: ");
        int choice = sc.nextInt() - 1;
        if (choice < 0 || choice >= sessionList.size()) {
            System.out.println("Wrong Input");
            return null;
        }
        while (sessionList.get(choice).getNumOfEmptySeat() <= 0) {
            System.out.println("Sorry! No more ticket available!");
            System.out.println("Please select another one: ");
            choice = sc.nextInt() - 1;
            if (choice < 0 || choice >= sessionList.size()) {
                System.out.println("Wrong Input");
                return null;
            }
        }
        Session selectedSession = sessionList.get(choice);
        cinema = selectedSession.getCinema();
        selectedSession.presentSeat();

        System.out.println("Select a seat");
        System.out.print("row:");
        int row = sc.nextInt() - 1;
        System.out.print("col:");
        int col = sc.nextInt() - 1;
        while (!selectedSession.seatAvailable(row, col)) {
            System.out.println("The input selection is not available!");
            System.out.println("Select another seat");
            System.out.print("row:");
            row = sc.nextInt() - 1;
            System.out.print("col:");
            col = sc.nextInt() - 1;
        }
        selectedSession.assignSeat(row, col);
        int ticketID = tiLib.size();
        Time bookTime = new Time().getCurrentTime();
        Ticket ti = new Ticket(toBook.getMovieName(),
                toBook.getTypeOfMovie(),
                cinema.getCinemaID(),
                cinema.getClassOfCinema(),
                cinema.getLocationOfCinema(),//Location!!!
                goer.getTypeOfMoviegoer(),
                null,
                bookTime,
                selectedSession.getTime(),
                row,
                col,
                ticketID);

        goer.setUnpaid(ticketID);
        System.out.println("Successed!");
        System.out.println("Please choose 4 to check, 5 to pay");
        return ti;
    }

    public LinkedList<Moviegoer> get() {
        return goerLib;
    }
}
