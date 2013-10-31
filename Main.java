package Moblima;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static Moviegoer curUser = null;

    private static MovieLib mLib = new MovieLib();
    private static MoviegoerLib gLib = new MoviegoerLib();
    private static Cineplexe cLib[];

    private static Scanner sc;
    private static Integer choice;

    public static void main(String[] args) {

        Cineplex theCineplex = new Cineplex[3];

        Menu.welcome();

        choice = sc.nextInt();


        while (1) {
            Menu.toplevel();


        }
    }

}