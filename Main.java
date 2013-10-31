package Moblima;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static final String adminPwd = "moblima";

    private static Moviegoer curUser = null;

    private static MovieLib movieLib = new MovieLib();
    private static MoviegoerLib goerLib = new MoviegoerLib();
    private static Cineplexe cLib[] = new Cineplex[3];

    private static Scanner sc;

    public static void main(String[] args) {;

        Menu.welcome();
        Menu.toplevel();

    }

}