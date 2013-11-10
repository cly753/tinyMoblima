package Moblima;

import java.util.*;
import java.io.*;

public class Main {

    public static final String adminPwd = "moblima";
    public static Moviegoer curUser = null;
    
    public static MovieLib movieLib = new MovieLib();
    public static MoviegoerLib goerLib = new MoviegoerLib();
    public static TicketLib tiLib = new TicketLib();
    public static Company company = new Company();

    public static Scanner sc = new Scanner(System.in);
    //private static final String fileParentLocation = ".\\src\\Moblima\\_info\\";

    private static final String fileParentLocation = "/home/lu/study/eclipse/Moblima/_info/";

    public static void main(String[] args) throws Exception {
        loading();
        Menu.welcome();
        Menu.toplevel(curUser, movieLib, goerLib, tiLib, company);
        storing();
    }

    private static void loading() throws Exception {
    	company.load(fileParentLocation);
    	movieLib.load(company, fileParentLocation);
    	tiLib.load(fileParentLocation);
        goerLib.load(fileParentLocation);
    }

    private static void storing() throws IOException {
    	movieLib.store(fileParentLocation);
    	tiLib.store(fileParentLocation);
        goerLib.store(fileParentLocation);
    }
}