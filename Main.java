package Moblima;

import java.util.*;
import java.io.*;

public class Main {
    public static final String adminPwd = "moblima";
    public static Moviegoer curUser = null;
    public static MovieLib movieLib = new MovieLib();
    public static MoviegoerLib goerLib = new MoviegoerLib();
    public static Cineplexe cLib[] = new Cineplex[3];
    public static Scanner sc;

    public static void main(String[] args) {;

        Menu.welcome();
        Menu.toplevel();

    }

}
