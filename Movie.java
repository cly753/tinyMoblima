package Moblima;

import java.util.*;

class Movie {

    private String movieName;
    private String typeOfMovie;
    private String cast;
    private String director;
    private String language;
    private int runtime;
    private String description;
    private Time openingTime;
    private ArrayList<Session> sessionList;
    private String rating;
    
    public static Scanner sc = new Scanner(System.in);

    public Movie(String movieName, String typeOfMovie, String cast, String director, String language,
            int runtime, String description, Time openingTime, String rating) {
        this.setMovieName(movieName);
        this.setTypeOfMovie(typeOfMovie);
        this.setCast(cast);
        this.setDirector(director);
        this.setLanguage(language);
        this.setRuntime(runtime);
        this.setDescription(description);
        this.setOpeningTime(openingTime);
        sessionList = new ArrayList<Session>();
        this.sessionList = new ArrayList<Session>();
        this.setRating(rating);
    }

    public Movie(String movieName, String typeOfMovie, String cast, String director, String language,
            int runtime, String description, Time openingTime, Time[] showtimeList, String rating) {
        this.setMovieName(movieName);
        this.setTypeOfMovie(typeOfMovie);
        this.setCast(cast);
        this.setDirector(director);
        this.setLanguage(language);
        this.setRuntime(runtime);
        this.setDescription(description);
        this.setOpeningTime(openingTime);
        sessionList = new ArrayList<Session>();
        this.setSessionList(showtimeList);
        this.setRating(rating);
    }
    
    public Movie(String movieName, String typeOfMovie, String cast, String director, String language,
            int runtime, String description, Time openingTime, ArrayList<Session> sessionList, String rating) {
        this.setMovieName(movieName);
        this.setTypeOfMovie(typeOfMovie);
        this.setCast(cast);
        this.setDirector(director);
        this.setLanguage(language);
        this.setRuntime(runtime);
        this.setDescription(description);
        this.setOpeningTime(openingTime);
        this.sessionList = sessionList;
        this.setRating(rating);
    }

    public String getMovieName() {
        return this.movieName;
    }

    public String getTypeOfMovie() {
        return this.typeOfMovie;
    }

    public String getCast() {
        return this.cast;
    }

    public String getDirector() {
        return this.director;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public String getDescription() {
        return this.description;
    }

    public Time getOpeningTime() {
        return this.openingTime;
    }

    public ArrayList<Session> getSessionList(boolean showPass) {
        if (showPass) {
            return this.sessionList;
        }
        ArrayList<Session> availableSession = new ArrayList<Session>();
        for (Session s : sessionList) {
            if (s.getTime().compareTo(new Time().getCurrentTime()) > 0) {
                availableSession.add(s);
            }
        }
        return availableSession;
    }

    public String getRating() {
        return this.rating;
    }

    public boolean setMovieName(String movieName) {
        this.movieName = movieName;
        return true;
    }

    public boolean setTypeOfMovie(String typeOfMovie) {
        this.typeOfMovie = typeOfMovie;
        return true;
    }

    public boolean setCast(String cast) {
        this.cast = cast;
        return true;
    }

    public boolean setDirector(String director) {
        this.director = director;
        return true;
    }

    public boolean setLanguage(String language) {
        this.language = language;
        return true;
    }

    public boolean setRuntime(int runtime) {
        this.runtime = runtime;
        return true;
    }

    public boolean setDescription(String description) {
        this.description = description;
        return true;
    }

    public boolean setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
        return true;
    }

    public boolean addSession(Session newSession) {
        this.sessionList.add(newSession);
        return true;
    }
    public boolean addSession(Time newShowtime) {
        System.out.println(">Please select cineplex: ");
        for (int i = 0; i < Main.company.get().size(); i++) {
            System.out.println((i + 1) + " : " + Main.company.get(i).getName());
        }
        int choice = sc.nextInt();
        Cineplex selectedCineplex = Main.company.get(choice-1);
        System.out.println(">Please select cinema: ");
        for (int i = 0; i < selectedCineplex.get().size(); i++) {
            System.out.println((i + 1) + " : Cinema " + selectedCineplex.get(i).getCinemaID());
        }
        choice = sc.nextInt();
        Cinema selectedCinema = selectedCineplex.get(choice - 1);
        Session newMovieSession = new Session(newShowtime, selectedCinema);
        this.sessionList.add(newMovieSession);
        return true;
    }

    public boolean setSessionList(Time[] showtimeArray) {
        for (int i = 0; i < showtimeArray.length; i++) {
            this.addSession(showtimeArray[i]);
        }
        return true;
    }

    public boolean deleteSession() {
        int x;
        for (int i = 0; i < sessionList.size(); i++) {
            System.out.print(">" + (i + 1) + " " + sessionList.get(i).getTime().getStr());
            System.out.println();
        }
        System.out.print("Delete: ");
        x = sc.nextInt() - 1;
        this.sessionList.remove(x);
        return true;
    }

    public boolean setRating(String rating) {
        this.rating = rating;
        return true;
    }

    public void showInfo() {
        int choice;

        System.out.println(">Movie Name: " + this.movieName);
        System.out.println(">Movie Type: " + this.typeOfMovie);
        System.out.print(">Cast: ");
        System.out.println(this.cast);

        System.out.print(">Director: ");
        System.out.println(this.director);

        System.out.println("------More------ input 1");
        choice = sc.nextInt();
        if (choice != 1) {
            return;
        }
        System.out.println(">Language: " + this.language);
        System.out.println(">Opening Time: ");
        openingTime.printTime();
        System.out.println(">Runtime: " + this.runtime);
        System.out.println(">Rating: " + this.rating);
        System.out.println("------More------ input 1");
        choice = sc.nextInt();
        if (choice != 1) {
            return;
        }
        System.out.println(this.description);
    }
}
