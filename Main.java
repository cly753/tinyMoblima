package Moblima;

import java.util.*;
import java.io.*;

public class Main {
    public static final String adminPwd = "moblima";
    public static Moviegoer curUser = null;
    public static MovieLib movieLib = new MovieLib();
    public static MoviegoerLib goerLib = new MoviegoerLib();
    public static Cineplex cLib[];
    public static TicketLib tiLib = new TicketLib();
    public static Scanner sc = new Scanner(System.in);
    public static int numOfCineplex;
    
    public static void main(String[] args) throws Exception {
        try {
            loading();
            Menu.welcome();
            Menu.toplevel(curUser, movieLib, goerLib, cLib);
            storing();
        }
        catch (Exception e) {
            System.out.print("I caught a exception!");
        }
    }
    private static void loading() throws Exception {
    	/*
         *2   \\number of Cineplex
         *A B \\the name of cineplex one and cineplex two
         *
         */
        Scanner freader = new Scanner(new FileReader("./_info_Cineplex" + ".txt"));
        numOfCineplex = freader.nextInt();
        cLib = new Cineplex[numOfCineplex];
        for (int i = 0; i < numOfCineplex; i++) {
            String nameOfCurrentCineplex = freader.next();
            cLib[i] = constructCineplex(nameOfCurrentCineplex);
            //directly go to a certain cineplex construction
        }

            
        /*
         *2       //number of tickets
         *
         *#1      //ticketID
         *3D      //typeOfMovie
         *cineA
         *student //typeOfMoviegoer
         *
         *#2      //ticketID
         *4D      //
         *cineB   //
         *others  //
         */
    }
    
    private static void storing() {
    	
    }
    private static Cineplex constructCineplex(String nameOfCineplex) throws Exception {
        /*
         *hall15 //location of cineplex
         *2      //number of cinema under this cineplex
         *cineA  //name of cinema one
         *cineB  //name of cinema two
         *
         */
        Cineplex currentCineplex;
        try {
            Scanner freader = new Scanner(new FileReader("./_info_cineplex" + nameOfCineplex + ".txt"));
            String locationOfCinplex = freader.next();
            int numOfCinema  = freader.nextInt();
            currentCineplex = new Cineplex(freader, nameOfCineplex, locationOfCinplex, numOfCinema);
            //constructor of cineplex which include cinema constructor
            return currentCineplex;
        } catch (Exception e) {
            System.out.println("asdf");
        }
        return null;
        //========================
        //help me fix here!!!!!!
        //========================
    }
}
