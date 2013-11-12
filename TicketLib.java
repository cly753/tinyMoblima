package Moblima;

import java.util.*;
import java.io.*;

public class TicketLib {

    private ArrayList<Ticket> tiLib;

    public TicketLib() {
        tiLib = new ArrayList<Ticket>();
    }

    public boolean addTicket(Ticket currentTicket) {
        tiLib.add(currentTicket);
        return true;
    }

    public int getNumOfTicket() {
        return tiLib.size();
    }
    
    public Ticket searchTicketByID(int ticketID) {
        for (Ticket t: tiLib) {
            if (t.getTicketID() == ticketID)
                return t;
        }
        return null;
    }

    public ArrayList<Ticket> get() {
        return tiLib;
    }
    public Ticket get(int i) {
    	return tiLib.get(i);
    }
    
    public Integer size() {
    	return tiLib.size();
    }
  
    public boolean store(String parentPath) throws IOException {
    	Properties p = new Properties();
    	
    	try {
    		FileInputStream fin = new FileInputStream(parentPath + "_TicketLib.txt");
			p.load(fin);
			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("file miss.");
			File f = new File(parentPath, "_TicketLib.txt"); // create if file is not there
			f.createNewFile();
			FileInputStream fin = new FileInputStream(parentPath + "_TicketLib.txt");
			p.load(new FileInputStream(parentPath + "_TicketLib.txt"));
			fin.close();
		}
    	
    	p.setProperty("__size", ((Integer)tiLib.size()).toString());
    	
    	for (int i = 0; i < tiLib.size(); i++) {
    		p.setProperty(String.format("%d_movieName", i), tiLib.get(i).getMovieName());
    		p.setProperty(String.format("%d_typeOfMovie", i), tiLib.get(i).getTypeOfMovie());
    		p.setProperty(String.format("%d_cinemaID", i), tiLib.get(i).getCinemaID()+"");
    		p.setProperty(String.format("%d_classOfCinema", i), tiLib.get(i).getClassOfCinema());
    		p.setProperty(String.format("%d_locationOfCineplex", i), tiLib.get(i).getLocationOfCineplex());
    		p.setProperty(String.format("%d_typeOfMoviegoer", i), tiLib.get(i).getTypeOfMoviegoer());
    		
    		if (tiLib.get(i).getBuyTime() == null) {
    		    p.setProperty(String.format("%d_buyTime", i), "-1"); 
    		} else {
    		    p.setProperty(String.format("%d_buyTime", i), tiLib.get(i).getBuyTime().toString());
    		}
    		
    		p.setProperty(String.format("%d_bookTime", i), tiLib.get(i).getBookTime().toString());
    		p.setProperty(String.format("%d_showtime", i), tiLib.get(i).getShowtime().toString());;
    		p.setProperty(String.format("%d_seatRow", i), tiLib.get(i).getSeatRow().toString());
    		p.setProperty(String.format("%d_seatColumn", i), tiLib.get(i).getSeatColumn().toString());
    		p.setProperty(String.format("%d_ticketID", i), tiLib.get(i).getTicketID().toString());
    	}
    	
    	FileOutputStream fout = new FileOutputStream(parentPath + "_TicketLib.txt");
    	p.store(fout, "_TicketLib");
    	fout.close();
    	
    	return true;
    }
    
    public boolean load(String parentPath) throws IOException {
    	Properties p = new Properties();
    	
    	try {
    		FileInputStream fin = new FileInputStream(parentPath + "_TicketLib.txt");
    		p.load(fin);
    		fin.close();
    	} catch (FileNotFoundException e) {
    		System.out.println("file miss.");
    		File f = new File(parentPath, "_TicketLib.txt"); // create if file is not there
			f.createNewFile();
			return false;
    	}
    	
    	int size = Integer.parseInt(p.getProperty("__size"));
    	
    	for (int i = 0; i < size; i++) {
    		Ticket temp = new Ticket();
    		
    		temp.setMovieName(p.getProperty(i + "_movieName"));
    		temp.setTypeOfMovie(p.getProperty(i + "_typeOfMovie"));
    		temp.setCinemaID(Integer.parseInt(p.getProperty(i + "_cinemaID")));
    		temp.setClassOfCinema(p.getProperty(i + "_classOfCinema"));
    		temp.setLocationOfCineplex(p.getProperty(i + "_locationOfCineplex"));
            temp.setTypeOfMoviegoer(p.getProperty(i + "_typeOfMoviegoer"));
            String buyTime = p.getProperty(i + "_buyTime");
            if (buyTime.compareTo("-1") == 0) {
                temp.setBuyTime(null);
            } else {
                temp.setBuyTime(new Time(buyTime));
            }
            Time time = new Time(p.getProperty(i + "_bookTime"));
            temp.setBookTime(time);
            time = new Time(p.getProperty(i + "_showtime"));
            temp.setShowtime(time);
            temp.setPrice();
            
            temp.setSeatRow(Integer.parseInt(p.getProperty(i + "_seatRow")));
            temp.setSeatCol(Integer.parseInt(p.getProperty(i + "_seatRow")));
            temp.setTicketID(Integer.parseInt(p.getProperty(i + "_ticketID")));
    		
            tiLib.add(Integer.parseInt(p.getProperty(i + "_ticketID")), temp);
    	}
    	return true;
    }

}
