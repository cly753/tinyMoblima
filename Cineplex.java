package Moblima;

import java.util.*;
import java.io.*;

class Cineplex {
    private final int numOfCinema = 3;
    private ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
    private String name;
    private String location;
    //private int id;

    public Cineplex() throws IOException {
        for (int i = 0; i < numOfCinema; i++) {
            cinemaList.add(new Cinema(10, 20, "SCE", this.location));
        }
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
}
