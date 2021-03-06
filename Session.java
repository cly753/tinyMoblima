package Moblima;

import java.math.BigInteger;

public class Session {

    private Time time;
    private Cinema cinema;
    private Seat[][] seat;
    private int numOfEmptySeat;

    public Session(Time time, Cinema cinema) {
        this.cinema = cinema;
        this.time = time;
        seat = new Seat[cinema.getRow()][cinema.getColumn()];
        for (int i = 0; i < cinema.getRow(); i++) {
            for (int j = 0; j < cinema.getColumn(); j++) {
                seat[i][j] = new Seat(i, j);
            }
        }
        setNumOfEmptySeat(cinema.getRow() * cinema.getColumn());
    }
    
    public Session(Company company, String s) {
    	String[] temp = s.split("##");
    	this.time = new Time(temp[0]);
        for (int i = 0; i < company.size(); i++) {
            for (Cinema cine : company.get(i).get()) {
                if (Integer.parseInt(temp[1]) == cine.getCinemaID()) {
                    this.cinema = cine;
                    break;
                }
            }
        }
        
    	this.setNumOfEmptySeat(this.cinema.getColumn() * this.cinema.getRow());
    	
        BigInteger seatInfo = new BigInteger(temp[2]);
        
    	String seatB = seatInfo.toString(2);
    	
    	while (seatB.length() < cinema.getColumn() * cinema.getRow()) {
    	    seatB = "0" + seatB;
    	}
    	
    	seat = new Seat[this.cinema.getRow()][this.cinema.getColumn()];
    	
    	for (int i = 0; i < cinema.getRow(); i++) {
    		for (int j = 0; j < cinema.getColumn(); j++) {
    		    seat[i][j] = new Seat(i, j);
    		    seat[i][j].unAssign();
    		    if ((seatB.charAt(cinema.getColumn() * i + j)+"").compareTo("1") == 0) {
    		        seat[i][j].assign();
    		        this.numOfEmptySeat--;
    		    }
    		}
    	}
    }
    
    public String toString() {
    	String seatStr = "";
    	for (int i = 0; i < cinema.getRow(); i++) {
    		for (int j = 0; j < cinema.getColumn(); j++) {
    			seatStr = seatStr + (seat[i][j].getAssign() ? "1" : "0");
    		}
    	}
    	BigInteger seatInfo = new BigInteger(seatStr, 2);
    	
    	return time.toString() + "##" + cinema.getCinemaID() + "##" + seatInfo.toString();
    }

    public Time getTime() {
        return this.time;
    }

    public Cinema getCinema() {
        return this.cinema;
    }

    public void presentSeat() {
        System.out.println("@Cinema : " + this.cinema.getCinemaID());
        if (numOfEmptySeat == 0) {
        	System.out.println("Sorry. Tickets all sold out.");
        	return ;
        }
        System.out.print("  ");
        for (int j = 0; j < cinema.getColumn() - 1; j++) {
            if (j == cinema.getColumn()/2)
                System.out.print(" ||");
            System.out.format(" %2d", j+1);
        }
        System.out.println(" " + cinema.getColumn());
        for (int j = 0; j < cinema.getColumn() + 1; j++) {
            if (j == cinema.getColumn()/2)
                System.out.print("__");
            System.out.print(" __");
        }
        for (int i = 0; i < cinema.getRow(); i++) {
            System.out.format("\n%2d|", i + 1);
            for (int j = 0; j < cinema.getColumn(); j++) {
                if (j == cinema.getColumn()/2)
                    System.out.print("||");
                if (seat[i][j].getAssign()) {
                    System.out.print(" x ");
                } else {
                    System.out.print(" 0 ");
                }
            }
        }
        System.out.println();
    }

    public boolean assignSeat(int row, int column) {
        if (this.seat[row][column] == null) {
            return false;
        }
        if (this.seat[row][column].getAssign()) {
            System.out.println("Seat already assgined to a customer.");
            return false;
        }
        this.seat[row][column].assign();
        setNumOfEmptySeat(getNumOfEmptySeat() - 1);
        System.out.println("Seat Assigned!");
        return true;
    }

    public boolean unAssignSeat(Integer row, Integer column) {
        if (this.seat[row][column] == null) {
            return false;
        }
        seat[row][column].unAssign();
        setNumOfEmptySeat(getNumOfEmptySeat() + 1);
        System.out.println("Seat Unassigned!");
        return true;
    }
    
    public boolean seatAvailable(Integer x, Integer y) {
        if ((x >= 0 && x < cinema.getRow()) && (y >=0 && y < cinema.getColumn())) {
            return (!seat[x][y].getAssign());
        } else {
            return false;
        }
    }

	public int getNumOfEmptySeat() {
		return numOfEmptySeat;
	}

	public void setNumOfEmptySeat(int numOfEmptySeat) {
		this.numOfEmptySeat = numOfEmptySeat;
	}
}
