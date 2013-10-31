package Moblima;

import java.util.ArrayList;

class MovieLib {
    private ArrayList<Movie> lib;

    public MovieLib() {
        lib = new ArrayList<Movie>;
    }

    public Movie[] searchMovie(String query) {
        //if find the query then return true
        ArrayList<Movie> result = new ArrayList<Movie>;
        for (int i = 0; i < lib.length; i++) {
            if (lib.get(i).movieName.compareTo(query) == 0) {
                result.add(0, lib.get(i));
            } else {
                if (lib.get(i).movieName.matches(query + "+")) {
                    result.add(result.size(), lib.get(i));
                }
            }
        }
        if (result.size() != 0) {
            System.out.println("Movie Found!");
            for (int i = 0; i < result.size(); i++) {
                System.out.println((i + 1) + result.get(i).movieName);
            }
        }
        return result.toArray();
    }
    
    public boolean add() {
        //here is the format of adding a movie.
        //hopefully will be our data format inside a txt file.
        
        System.out.println("Name: ");
        String nameOfNewMovie = sc.nextline();

        System.out.println("Type: ");
        String typeOfNewMove  = sc.next();

        System.out.println("Cast: ");
        String[] castOfNewMovie = sc.nextLine().split(" ");

        System.out.println("Director: ");
        String[] directorOfNewMovie = sc.nextLine().split(" ");

        System.out.println("Language: ");
        String languageOfNewMovie = sc.next();

        System.out.println("Runtime: ");
        int runtimeOfNewMovie =sc.nextInt();

        System.out.println("Description:");
        String[] description = sc.nextLine().split(" ");

        System.out.println("number of Showtime: ");
        int numOfShowtime = sc.nextInt();
        Time[] showtimeOfMovie = new Time[numOfShowtime];
        for (int i = 0; i < numOfShowtime; i++) {
            Time showtimeOfMovie = Time.manualNewATime();
        }

        System.out.print("Opening time: ");
        Time OpeningTime = Time.manualNewATime();
        
        System.out.print("Rating: ");
        String ratingOfNewMovie = sc.next();
        
        Movie newMovie = new Movie(nameOfMovie,
                                   typeOfNewMove, 
                                   castOfNewMovie, 
                                   directorOfNewMovie, 
                                   languageOfNewMovie,
                                   runtimeOfNewMovie,
                                   description,
                                   showtimeOfMovie,
                                   openingTime,
                                   rating);
        
        lib.add(0, newMovie);
        return true;
    }

    public boolean remove(String movieName) {
        int i;
        boolean flag = false;
        for (i = 0; i < lib.size(); i++) {
            if (lib.get(i).movieName.compareTo(movieName) == 0) {
                lib.remove(i);
                flag = true;
            }
        }
        if (!flag)
            return false;
        return true;
    }

    public boolean modify(String movieName, int choice) {
        int i;

        for (i = 0; i < lib.size(); i++) {
            if (lib.get(i).movieName.compareTo(movieName) == 0) {
                break;
            }
        }
        
        if (i == lib.size()) {
            return false;
        }
        
        switch (choice) {
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
            default:
                System.out.println("invalid. again: ");
                return false;
        }
        return true;
    }
    
    public static void listMovie(MovieLib lib, Scanner sc) {
        System.out.print("From: ");
        int start = sc.nextInt();
        System.out.print("To: ");
        int end = sc.nextInt();

        ListIterator iterA = new lib.listIterator(start);
        ListIterator iterB = new lib.listIterator(end);

        while (iterA != iterB && iterA.hasNext()) {
            System.out.println(start + "." + iterA.next().movieName);
            start++;
        }
    }
}
