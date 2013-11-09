package Moblima;

class Cinema {
    private Integer cinemaID;
    private final Integer row;
    private final Integer column;
//    private int numOfSeat; // ???
    private String classOfCinema;
    private String locationOfCinema;
//    private Seat[][] seat;
//    private int numOfEmptySeat;
    private String description;
    
//    private BufferedReader br; // what is it

//    public Cinema(Scanner br, int row, int column, String nameOfCinema, String locationOfCinema) throws IOException {
//        this.row = row;
//        this.column = column;
////        seat = new Seat[row][column];
////        this.setNumOfSeat();
////        for (int i = 0; i < row; i++) {
////            for (int j = 0; j < column; j++) {
////                seat[i][j] = new Seat(i, j);
////            }
////        }
////        numOfEmptySeat = numOfSeat;
//        this.setNameOfCinema(nameOfCinema);
//        this.setLocationOfCinema();
//        this.setClassOfCinema(); //use scanner
//        this.setDescription();   //use scanner
//    }
    
    public Cinema(String p) {
    	String[] temp = p.split(" ");
    	this.cinemaID = Integer.parseInt(temp[0]);
    	this.row = Integer.parseInt(temp[1]);
    	this.column = Integer.parseInt(temp[2]);
    	this.classOfCinema = temp[3];
    	this.locationOfCinema = temp[4];
    	this.description = temp[5];
//    	seat = new Seat[row][column];
//    	for (int i = 0; i < row; i++) {
//    		for (int j = 0; j < column; j++)
//    			seat[i][j] = new Seat(i, j);
//    	}
    }
    
    
//    public Cinema(Properties p) {
//    	this.nameOfCinema = p.getProperty("__nameOfCinema");
//    	this.row = Integer.parseInt(p.getProperty("__row"));
//    	this.column = Integer.parseInt(p.getProperty("__column"));
//    	this.classOfCinema = p.getProperty("__classOfCinema");
//    	this.locationOfCinema = p.getProperty("__locationOfCinema");
//    	this.description = p.getProperty("__description");
//    }

//    public boolean setNumOfSeat() { // how can you set it? if row and column are fixed, numofseat should be fixed?
//        this.numOfSeat = row * column;
//        return true;
//    }

//    public int getNumOfSeat() {
//        return this.numOfSeat;
//    }

//    public int getNumOfEmptySeat() {
//        return this.numOfEmptySeat;
//    }

    public boolean setCinemaID(Integer cinemaID) {
        this.cinemaID = cinemaID;
        return true;
    }

    public Integer getCinemaID() {
        return this.cinemaID;
    }

//    public boolean setClassOfCinema() throws IOException {
//        String cinemaClass = br.readLine();
//        this.classOfCinema = cinemaClass;
//        return true;
//    }

    public String getClassOfCinema() {
        return this.classOfCinema;
    }

    public boolean setLocationOfCinema(String locationOfCinema) {
        this.locationOfCinema = locationOfCinema;
        return true;
    }

    public String getLocationOfCinema() {
        return this.locationOfCinema;
    }

//    public boolean setDescription() throws IOException {
//        String cinemaDescription;
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//
//            while (line != null) {
//                sb.append(line);
//                sb.append("\n");
//                line = br.readLine();
//            }
//            cinemaDescription = sb.toString();
//        } finally {
//            this.br.close();
//        }
//        this.description = cinemaDescription;
//        return true;
//    }
    
    public boolean setDescription(String description) {
    	this.description = description;
		return true;
    }

    public String getDescription() {
        return this.description;
    }

//    public Seat getSeat(int row, int col) {
//        return seat[row][col];
//    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public String toString() {
    	return cinemaID.toString() + " " + row.toString() + " " + column.toString() + " " + classOfCinema + " " + locationOfCinema + " " + description;
    }

}
