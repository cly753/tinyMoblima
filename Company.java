package Moblima;

import java.io.*;
import java.util.*;

public class Company {

    private ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
    
    public Company() {
    	cineplexList = new ArrayList<Cineplex>();
    }
    
    public void load(String fileParentLocation) throws IOException {
    	
    	/*structure of _Company.txt
    	 * 
    	 *__size=number of cineplex
    	 *i_name=name of cineplex
    	 *i_location=location of cineplex
    	 *i_size=number of cinema in ith cineplex
    	 *i_cinema_j=jth cinema of ith cineplex (format: "CinemaID row column classOfCinema locationOfCinema description")
    	 * 
    	 */

        String fileLocation = fileParentLocation + "_Company.txt";
        try {
            Properties p = new Properties();
            p.load(new FileInputStream(fileLocation));

            for (int i = 0; i < Integer.parseInt(p.getProperty("__size")); i++) {
            	int numOfCinema = Integer.parseInt(p.getProperty(i + "_size"));
            	ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
            	for (int j = 0; j < numOfCinema; j++) {
            		Cinema cinema = new Cinema(p.getProperty(i + "_cinema_" + j));
            		cinemaList.add(cinema);
            	}
            	
            	Cineplex cineplex = new Cineplex(null, null, 0, null, cinemaList);
            	
            	cineplex.setCineplexID(i);
            	cineplex.setName(p.getProperty(i + "_name"));
            	cineplex.setLocation(p.getProperty(i + "_location"));
            	cineplex.setNumOfCinema(numOfCinema);
            	cineplexList.add(cineplex);
            	
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to process " + fileLocation);
        }
    }
    
    public ArrayList<Cineplex> get() {
        return cineplexList;
    }
    
    public int size() {
    	return cineplexList.size();
    }
    
    public Cineplex get(int i) {
    	return cineplexList.get(i);
    }
}
