package Moblima;

import java.util.ArrayList;

public class MovieLib {
    private ArrayList<Movie> lib;

    public MovieLib() {
        lib = new ArrayList<Movie>;
    }

    public static Movie[] searchMovie(MovieLib lib, String query) {

        ArrayList<Movie> result = new ArrayList<Movie>;

        for (int i = 0; i < lib.length; i++) {
            if (lib.get(i).movieName.compareTo(query) == 0) {
                result.add(0, lib.get(i));
            }
            else if (lib.get(i).movieName.matches(query + "+")) {
                result.add(result.size(), lib.get(i));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(i + "." + result.get(i).movieName);
        }

        return result.toArray();
    }

    public static boolean add(MovieLib lib, Scanner sc) {
        lib.add(0, Movie.manualNewAMovie(sc));
        return true;
    }

    public static boolean remove(MovieLib lib, String movieName) {
        Integer i;

        for (i = 0; i < lib.size(); i++) {
            if (lib.get(i).movieName.compareTo(movieName) == 0) {
                lib.remove(i);
            }
        }

        if (i == lib.size())
            return false;
        return true;
    }

    public static boolean modify(MovieLib lib, String movieName, Integer choice, Scanner sc) {
        Integer i;

        for (i = 0; i < lib.size(); i++) {
            if (lib.get(i).movieName.compareTo(movieName) == 0) {
                break;
            }
        }

        if (i == lib.size())
            return false;

        Menu.modify();
        while (choice != 17) {
            switch (choice)
                case -1:
                    listMovie(sc);
                case 0:
                    Menu.modify();
                case 1:
                    System.out.print("New name: ");
                    lib.get(i).setMovieName(sc.nextLine());
                    break;
                case 2:
                    System.out.print("New type: ");
                    lib.get(i).setTypeOfMovie(sc.next());
                    break;
                case 3:
                    System.out.print("New cast: ");
                    lib.get(i).setCast(sc.nextLine().split(" "));
                    break;
                case 4:
                    System.out.print("New director: ");
                    lib.get(i).setDirector(sc.nextLine().split(" "));
                    break;
                case 5:
                    System.out.print("New language: ");
                    lib.get(i).setLanguage(sc.next());
                    break;
                case 6:
                    System.out.print("New runtime: ");
                    lib.get(i).setRuntime(sc.nextInt());
                    break;
                case 7:
                    System.out.print("New description: ");
                    lib.get(i).setDescription(sc.nextLine());
                    break;
                case 8:
                    System.out.print("New openingTime: ");
                    lib.get(i).setOpeningTime(Time.manualNewATime());
                    break;
                case 9:
                    System.out.print("New showtime : ");
                    lib.get(i).addShowtime(Time.manualNewATime());
                    break;
                case 10:
                    lib.get(i).deleteShowtime(sc);
                    break;
                case 11:
                    lib.get(i).setRatingBB(sc);
                    break;
                case 17:
                    break;
                default:
                    System.out.println("invalid. again: ");
                    choice = sc.nextInt();
                    break;
        }
        return true;
    }

    public static void listMovie(MovieLib lib, Scanner sc) {
        System.out.print("From: ");
        Integer start = sc.nextInt();
        System.out.print("To: ");
        Integer end = sc.nextInt();

        ListIterator iterA = new lib.listIterator(start);
        ListIterator iterB = new lib.listIterator(end);

        while (iterA != iterB && iterA.hasNext()) {
            System.out.println(start + "." + iterA.next().movieName);
            start++;
        }
    }
}