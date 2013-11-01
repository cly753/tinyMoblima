package Moblima;

import java.util.*;
import java.io.*;

class Movie {
    private String movieName;
    private String typeOfMovie;
    private String[] cast;
    private String[] director;
    private String language;
    private int runtime;
    private String[] description;
    private Time openingTime;
    private ArrayList<Time> showtimeList;
    private String rating;
    public static Scanner sc = new Scanner(System.in);
    
    private static final String ratingList[] = {"G", "PG", "R18"};
    
    public Movie(String movieName, String typeOfMovie, String[] cast, String[] director, String language,
                  int runtime, String[] description, Time openingTime, Time[] showtimeArray, String rating) {
        this.setMovieName(movieName);
        this.setTypeOfMovie(typeOfMovie);
        this.setCast(cast);
        this.setDirector(director);
        this.setLanguage(language);
        this.setRuntime(runtime);
        this.setDescription(description);
        this.setShowtimeList(showtimeArray);
        this.setRating(rating);
    }

    /*    public static Movie manualNewAMovie() {
        Movie newMovie = new Movie();
        newMovie.setRatingBB(sc);
        }*/
    //deleted by Shengliang
    //modified this function to movieLib.add() at MovieLib
    
    public String getMovieName() {
        return this.movieName;
    }
    public String getTypeOfMovie() {
        return this.typeOfMovie;
    }
    public String[] getCast() {
        return this.cast;
    }
    public String[] getDirector() {
        return this.director;
    }
    public String getLanguage() {
        return this.language;
    }
    public int getRuntime() {
        return this.runtime;
    }
    public String[] getDescription() {
        return this.description;
    }
    public Time getOpeningTime() {
        return this.openingTime;
    }
    public ArrayList<Time> getShowtimeList() {
        return this.showtimeList;
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
    public boolean setCast(String[] cast) {
        this.cast = cast;
        return true;
    }
    public boolean setDirector(String[] director) {
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
    public boolean setDescription(String[] description) {
        this.description = description;
        return true;
    }
    public boolean setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
        return true;
    }
    public boolean deleteShowtime() {
        int x;
        for (int i = 0; i < showtimeList.size(); i++) {
            System.out.print(i + " " + showtimeList.get(i).getStr());
            System.out.println();
        }
        System.out.print("Delete: ");
        x = sc.nextInt();
        this.showtimeList.remove(x);
        return true;
        //how about this.....
        //instead of return this.showtimeList.remove(x)
    }
    public boolean setRating(String rating) {
        this.rating = rating;
        return true;
    }
    public boolean setRatingBB() {
        for (int i = 0; i < ratingList.length; i++) {
            System.out.print((i+1) + "." + ratingList[i]);
        }
        System.out.println("\nSelect new rating: ");
        this.setRating(ratingList[sc.nextInt()]);
        return true;
    }

    public boolean addShowtime(Time newShowtime) {
        this.showtimeList.add(newShowtime);
        return true;
    }
    public boolean setShowtimeList(Time[] showtimeArray) {
        for (int i = 0; i < showtimeArray.length; i++) {
            this.addShowtime(showtimeArray[i]);
        }
        return true;
    }

    public void showInfo() {
        int choice;
        
        System.out.println("Movie Name: " + this.movieName);
        System.out.println("Movie Type: " + this.typeOfMovie);
        System.out.print("Cast: ");
        for (int i = 0; i < this.cast.length - 1; i++) {
            System.out.print(this.cast[i] + " ");
        }
        System.out.println(this.cast[cast.length - 1]);
        
        System.out.print("Director: ");
        for (int i = 0; i < this.director.length - 1; i++) {
            System.out.print(this.director[i] + " ");
        }
        System.out.println(this.director[this.director.length - 1]);
        
        System.out.println("---More--- input 1");
        choice = sc.nextInt();
        if (choice != 1) {
            return;
        }
        System.out.println("Language: " + this.language);
        System.out.println("Opening Time: ");
        openingTime.printTime();
        System.out.println("Runtime: " + this.runtime);
        System.out.println("Rating: " + this.rating);
        System.out.println("---More--- input 1");
        choice = sc.nextInt();
        if (choice != 1) {
            return;
        }
        System.out.println("===============description===============");
        for (int i = 0; i < this.description.length - 1; i++) {
            System.out.print(this.description[i] + " ");
        }
        System.out.println(this.description[this.description.length - 1]);
    }   
}
