package Moblima;

import java.util.*;

class Cineplex {

    
    private ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
    private String name;
    private String location;
    private int numOfCinema;
    private Integer cineplexID;

//    public Cineplex(Scanner freader, String nameOfCineplex, String locationOfCinplex, int numOfCinema) throws IOException {
//        this.numOfCinema = numOfCinema;
//        this.name = nameOfCineplex;
//        this.location = locationOfCinplex;
//        for (int i = 0; i < numOfCinema; i++) {
//            String nameOfCurrentCinema = freader.next();
//            Cinema currentCinema = constructCinema(nameOfCurrentCinema, this.location);
//            cinemaList.add(currentCinema);
//        }
//    }
    
    public Cineplex(String name, String location, int numOfCinema, Integer cineplexID, ArrayList<Cinema> cinemaList) {
    	this.name = name;
    	this.location = location;
    	this.numOfCinema = numOfCinema;
    	this.cineplexID = cineplexID;
    	this.cinemaList = cinemaList;
    }
    

//    private Cinema constructCinema(String nameOfCinema, String locationOfCinema) throws IOException {
//        /*
//         *
//         *10 20  //row and column
//         *diyideng //class of cinema this.setClassOfCinema();
//         *1234asdf asdf2 //set description
//         *
//         */
//        try {
//            Scanner freader = new Scanner(new FileReader("./_info_Cinema" + nameOfCinema + ".txt"));
//            int row = freader.nextInt();
//            int column = freader.nextInt();
//            Cinema currentCinema = new Cinema(freader, row, column, nameOfCinema, locationOfCinema);
//            //directly go to cinema constructor
//            return currentCinema;
//        } catch (IOException e) {
//            System.out.println("asdf");
//        }
//        return null;
//        //========================
//        // help me fix here!!!!!!
//        // no...
//        //========================
//    }

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
