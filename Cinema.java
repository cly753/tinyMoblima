package Moblima;

public class Cinema {
    private final Integer row;
    private final Integer column;
    private Seat theSeat[][];
    private static final String allClass[] = {"Normal", "Platinum"};
    private Integer theClass;

    public Cinema() {
        theSeat = new Seat[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                theSeat[i][j] = new Seat(i, j);
            }
        }

        theClass = 0;
    }

    public boolean setClass(Integer theClass) {
        this.theClass = theClass;
        return true;
    }
    public Integer getClass() {
        return theClass;
    }

    public boolean assignSeat(Integer row, Integer column) {
        return theSeat[row][column].assign();
    }
    public boolean unAssignSeat(Integer row, Integer column) {
        return theSeat[row][column].unAssign();
    }
    public boolean getSeatStatus(Integer row, Integer column) {
        theSeat[row][column].getAssign();
    }

}