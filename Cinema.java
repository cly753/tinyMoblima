package Moblima;

import java.util.*;
import java.io.*;

class Cinema {
    private final Integer row;
    private final Integer column;
    private String nameOfCinema;
    private int numOfSeat;
    private String classOfCinema;
    private String locationOfCinema;
    private Seat[][] seat;
    private int numOfEmptySeat;
    private String[] description;
    private BufferedReader br;
    
    public Cinema(Scanner br, int row, int column, String nameOfCinema, String locationOfCinema) throws IOException {
    	this.row = row;
    	this.column = column;
        seat = new Seat[row][column];
        this.setNumOfSeat();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                seat[i][j] = new Seat(i, j);
            }
        }
        numOfEmptySeat = numOfSeat;
        //br = new BufferedReader(new FileReader("_info_detail_" + nameOfCinema + ".txt"));
        this.setNameOfCinema(nameOfCinema);
        this.setClassOfCinema();
        this.setLocationOfCinema();
        this.setDescription();
    }
    
    public boolean setNumOfSeat() {
        this.numOfSeat = row * column;
        return true;
    }
    public int getNumOfSeat() {
        return this.numOfSeat;
    }
    
    public int getNumOfEmptySeat() {
        return this.numOfEmptySeat;
    }
    
    public boolean setNameOfCinema(String nameOfCinema) {
        this.nameOfCinema = nameOfCinema;
        return true;
    }
    public String getNameOfCinema() {
        return this.nameOfCinema;
    }
    
    public boolean setClassOfCinema() throws IOException {
        String cinemaClass = br.readLine();
        this.classOfCinema = cinemaClass;
        return true;
    }
    public String getClassOfCinema() {
        return this.classOfCinema;
    }

    public boolean setLocationOfCinema() {
        this.locationOfCinema = locationOfCinema;
        return true;
    }
    public String getLocationOfCinema() {
        return this.locationOfCinema;
    }
    
    public boolean setDescription() throws IOException {
        String[] cinemaDescription;
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            cinemaDescription = sb.toString().split("\n");
        } finally {
            this.br.close();
        }
        this.description = cinemaDescription;
        return true;
    }
    public String[] getDescription() {
        return this.description;
    }

    public Seat getSeat(int row, int col) {
        return seat[row][col];
    }
    public int getRow() {
        return this.row;
    }
    public int getColumn() {
        return this.column;
    }   
}
