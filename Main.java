package Moblima;

import java.util.*;
import java.io.*;

public class Main {
    public static final String adminPwd = "moblima";
    public static Moviegoer curUser = null;
    public static MovieLib movieLib = new MovieLib();
    public static MoviegoerLib goerLib = new MoviegoerLib();
    public static Cineplex cLib[];
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
    	
        Scanner freader = new Scanner(new FileReader(".\\_info_Cineplex" + ".txt"));
        numOfCineplex = freader.nextInt();
        cLib = new Cineplex[numOfCineplex];
        for (int i = 0; i < numOfCineplex; i++) {
            String nameOfCurrentCineplex = freader.next();
            cLib[i] = constructCineplex(nameOfCurrentCineplex);
        }
    }
    
    private static void storing() {
    	
    }
    private static Cineplex constructCineplex(String nameOfCineplex) throws Exception {
    	
        Cineplex currentCineplex;
        try {
            Scanner freader = new Scanner(new FileReader(".\\_info_cineplex" + nameOfCineplex + ".txt"));
            String locationOfCinplex = freader.next();
            int numOfCinema  = freader.nextInt();
            currentCineplex = new Cineplex(freader, nameOfCineplex, locationOfCinplex, numOfCinema);
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
