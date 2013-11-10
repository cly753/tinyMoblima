package Moblima;

import java.util.*;

class Cineplex {

    
    private ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
    private String name;
    private String location;
    private int numOfCinema;
    private Integer cineplexID;

    public Cineplex(String name, String location, int numOfCinema, Integer cineplexID, ArrayList<Cinema> cinemaList) {
    	this.name = name;
    	this.location = location;
    	this.numOfCinema = numOfCinema;
    	this.cineplexID = cineplexID;
    	this.cinemaList = cinemaList;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public String getLocation() {
        return location;
    }

    public boolean setLocation(String location) {
        this.location = location;
        return true;
    }

    public Cinema get(int i) {
        return cinemaList.get(i);
    }
    
    public ArrayList<Cinema> get() {
        return cinemaList;
    }

    public Integer getCineplexID() {
    	return this.cineplexID;
    }
    
    public Integer getNumOfCinema() {
    	return this.numOfCinema;
    }
    
    public boolean setCineplexID(Integer id) {
    	this.cineplexID = id;
    	return true;
    }

    public boolean setNumOfCinema(Integer n) {
    	this.numOfCinema = n;
		return true;
    }
}
