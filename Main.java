package Moblima;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static Movie movieLib[];
    private static Moviegoer mgoerLib[];
    private static Cineplex cLib[];

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