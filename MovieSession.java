package Moblima;

public class MovieSession {

	private Time time;
	private Seat[][] seat;
    private int numOfEmptySeat;
	private Cinema cinema;

	public MovieSession(Cinema cinema, Time time) {
        this.cinema = cinema; // reference
        this.time = time; // new a time
        seat = new Seat[cinema.getRow()][cinema.getColumn()];
        for (int i = 0; i < cinema.getRow(); i++) {
            for (int j = 0; j < cinema.getColumn(); j++) {
                seat[i][j] = new Seat(i, j);
                if (cinema.getSeat(i, j) == null)
                    seat[i][j] = null;
            }
        }
        numOfEmptySeat = cinema.getRow() * cinema.getColumn();
	}

    public boolean assignSeat(int row, int column) {
        if (this.seat[row][column] == null)
            return false;

        if (this.seat[row][column].getAssign()) {
            System.out.println("Seat already assgined to a customer.");
            return false;
        }
        this.seat[row][column].assign();
        numOfEmptySeat--;
        System.out.println("Seat Assigned!");
        return true;
    }
    
    public boolean unAssignSeat(Integer row, Integer column) {
        if (this.seat[row][column] == null)
            return false;

        seat[row][column].unAssign();
        numOfEmptySeat++;
        System.out.println("Seat Unassigned!");
        return true;
    }
}