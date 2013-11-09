package Moblima;

import java.io.*;
import java.util.*;

public class Company {

    private ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
    private String name;
    
    public Company() {
    	cineplexList = new ArrayList();
    }
    
    public void load(String fileParentLocation) throws IOException {
    	
    	/*structure of _Company.txt
    	 * 
    	 *__size=number of cineplex
    	 *i_size=number of cinema in ith cineplex
    	 *i_cinema_j=jth cinema of ith cineplex (format: "CinemaID row column classOfCinema locationOfCinema description")
    	 * 
    	 */

        String fileLocation = fileParentLocation + "_Company.txt";
        try {
            Properties p = new Properties();
            p.load(new FileInputStream(fileLocation));

            this.name = p.getProperty("__name");
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
            	cineplex.setNumOfCinema(Integer.parseInt(p.getProperty(i + "_size")));
            	
            	cineplexList.add(cineplex);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to process " + fileLocation);
        }
    }
    
    public ArrayList<Cineplex> get() {
        return cineplexList;
    }
    
    public Cineplex get(int i) {
    	return cineplexList.get(i);
    }
}
