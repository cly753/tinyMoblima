package Moblima;

import java.util.*;
import java.io.*;

class Ticket {

    //private Integer movieId;
    private String movieName;
    private String typeOfMovie;
    private Integer cinemaID;
    private String classOfCinema;
    private String locationOfCineplex;
    private String typeOfMoviegoer;
    private Time buyTime;
    private Time bookTime;
    private Time showTime;
    private double price;
    private Integer seatRow;
    private Integer seatColumn;
    private Integer ticketID;
    
    //
    //
    // ticket constructor does not have Time, is it fine?
    //
    //

    public Ticket(String movieName, String typeOfMovie, Integer cinemaID, String classOfCinema, String locationOfCineplex,
            String typeOfMoviegoer, Time showTime, Integer row, Integer col, Integer ticketID) {
        this.setMovieName(movieName);
        this.setTypeOfMovie(typeOfMovie);
        this.setCinemaID(cinemaID);
        this.setClassOfCinema(classOfCinema);
        this.setLocationOfCineplex(locationOfCineplex);
        this.setTypeOfMoviegoer(typeOfMoviegoer);
        this.setShowTime(showTime);
        this.setSeatRow(row);
        this.setSeatCol(col);
        this.setTicketID(ticketID);
        this.setPrice();
    }

    public String getMovieName() {
        return this.movieName;
    }

    public String getTypeOfMovie() {
        return this.typeOfMovie;
    }

    public Integer getCinemaID() {
        return this.cinemaID;
    }

    public String getClassOfCinema() {
        return this.classOfCinema;
    }

    public String getLocationOfCineplex() {
        return this.locationOfCineplex;
    }

    public String getTypeOfMoviegoer() {
        return this.typeOfMoviegoer;
    }

    public Time getShowTime() {
        return this.showTime;
    }

    public double getPrice() {
        return this.price;
    }

    public Integer getSeatRow() {
        return this.seatRow;
    }

    public Integer getSeatColumn() {
        return this.seatColumn;
    }

    public Integer getTicketID() {
        return this.ticketID;
    }

    public Time getBookTime() {
    	return bookTime;
    }
    
    public Time getBuyTime() {
        return buyTime;
    }

    public boolean setMovieName(String movieName) {
        this.movieName = movieName;
        return true;
    }

    public boolean setTypeOfMovie(String typeOfMovie) {
        this.typeOfMovie = typeOfMovie;
        return true;
    }

    public boolean setCinemaID(Integer cinemaID) {
        this.cinemaID = cinemaID;
        return true;
    }

    public boolean setClassOfCinema(String classOfCinema) {
        this.classOfCinema = classOfCinema;
        return true;
    }

    public boolean setLocationOfCineplex(String locationOfCineplex) {
        this.locationOfCineplex = locationOfCineplex;
        return true;
    }

    public boolean setTypeOfMoviegoer(String typeOfMoviegoer) {
        this.typeOfMoviegoer = typeOfMoviegoer;
        return true;
    }

    public boolean setShowTime(Time showTime) {
        this.showTime = showTime;
        return true;
    }

    public boolean setSeatCol(Integer col) {
        this.seatColumn = col;
        return true;
    }

    public boolean setSeatRow(Integer row) {
        this.seatRow = row;
        return true;
    }

    public boolean setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
        return true;
    }

    public boolean setBookTime(Time bookTime) {
    	this.bookTime = bookTime;
    	return true;
    }
    
    public boolean setBuyTime(Time buyTime) {
        this.buyTime = buyTime;
        return true;
    }

    public boolean setPrice() {
        if (this.typeOfMoviegoer == "Senior Citizen") {
            if (this.typeOfMovie == "Digital Movie") {
                if (this.showTime.getWeekday()) {
                    this.price = 4;
                    return true;
                }
            }
        }
        if (this.typeOfMoviegoer == "Student") {
            if (this.typeOfMovie == "Digital Movie") {
                if (this.showTime.getWeekday()) {
                    this.price = 7;
                    return true;
                }
            } else {
                this.price = 9;
                return true;
            }
        }
        if (this.showTime.getWeekday()) {
            if (this.typeOfMovie == "Digital Movie") {
                this.price = 9.5;
            } else {
                this.price = 11;
            }
            return true;
        } else {
            if (this.typeOfMovie == "Digital Movie") {
                this.price = 11;
            } else {
                this.price = 15;
            }
            return true;
        }
    }

    public static void display(Ticket ti) {
        System.out.println(ti.getMovieName() + " " + ti.getTypeOfMovie());
        System.out.println(ti.getShowTime());
        System.out.println(ti.getSeatRow() + " " + ti.getSeatColumn() + " " + ti.getTicketID() + " " + ti.getTypeOfMoviegoer());
        System.out.println(ti.getClassOfCinema() + " " + ti.getLocationOfCineplex());
    }
}
