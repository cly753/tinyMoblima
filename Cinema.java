package Moblima;

class Cinema {
    private final Integer row;
    private final Integer column;
    private String nameOfCinema;
    private int numOfSeat;
    private String classOfCinema;
    private Seat[][] seat;
    private int numOfEmptySeat;
    private String[] description;
    //I suggest we use txt file to store 3 Cinemas info
    //And load it every time before start
    private BufferedReader br;
    
    public Cinema() {
        theSeat = new Seat[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                theSeat[i][j] = new Seat(i, j);
            }
        }

        theClass = 0;
    }
    public Cinema(int row, int column, String nameOfCinema) {
        seat = new Seat[row][column];
        this.setNumOfSeat();
        seat = new Seat[numOfSeat];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                seat[i][j] = new Seat(i, j);
            }
        }
        numOfEmptySeat = numOfSeat;
        br = new BufferedReader(new FileReader(this.name + ".txt"));
        this.setNameOfCinema(nameOfCinema);
        this.setClassOfCinema();
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
    
    public boolean setClassOfCinema() {
        String cinemaClass = br.next();
        this.classOfCinema = cinemaClass;
        return true;
    }
    public String getClassOfCinema() {
        return this.classOfCinema;
    }
    
    public boolean setDescription() {
        try {
            StringBuilder sb = new StringBuilder();
            String line = this.br.readLine();
            
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = this.br.readLine();
            }
            String[] cinemaDescription = sb.toString().split("\n");
        } finally {
            this.br.close();
        }
        this.description = cinemaDescription;
        return true;
    }
    public String[] getDescription() {
        return this.description;
    }
    
    public void assignSeat(int row, int column) {
        if (this.seat[row][column].getAssign()) {
            System.out.println("Seat already assgined to a customer.");
            return;
        }
        this.seat[row][column].setAssign();
        numOfEmptySeat--;
        System.out.println("Seat Assigned!");
        return true;
    }
    public boolean unAssignSeat(Integer row, Integer column) {
        theSeat[row][column].unAssign();
        numOfEmptySeat++;
        System.out.println("Seat Unassigned!");
        return true;
    }
}
