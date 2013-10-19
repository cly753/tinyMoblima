package Moblima;

class Cinema {
    private String nameOfCinema;
    private int numOfSeat;
    private String classOfCinema;
    private Seat[] seat;
    private int numEmptySeat;
    private String[] description;
    //I suggest we use txt file to store 3 Cinemas info
    //And load it every time before start
    private BufferedReader br;
    
    public Cinema(int numOfSeat, String nameOfCinema) {
        this.setNumOfSeat();
        seat = new Seat[numOfSeat];
        for (int i = 0; i < numOfSeat; i++) {
            seat[i] = new Seat();
        }
        numEmptySeat = numOfSeat;
        br = new BufferedReader(new FileReader(this.name + ".txt"));
        this.setNameOfCinema(nameOfCinema);
        this.setClassOfCinema();
        this.setDescription();
    }
    
    public boolean setNameOfCinema(String nameOfCinema) {
        this.nameOfCinema = nameOfCinema;
        return true;
    }
    public boolean setClassOfCinema() {
        String cinemaClass = br.next();
        this.classOfCinema = cinemaClass;
        return true;
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
        return boolean;
    }
    




    public void assignSeat(int seatId) {
        if (this.seat[seatId].getAssign()) {
            System.out.println("Seat already assgined to a customer.");
            return;
        }
        this.seat[].setAssign();
        numEmptySeat--;
        System.out.println("  Seat Assigned!");
    }
    
}
