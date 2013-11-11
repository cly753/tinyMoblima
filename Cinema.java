package Moblima;

class Cinema {
    private Integer cinemaID;
    private final Integer row;
    private final Integer column;
    private String classOfCinema;
    private String locationOfCinema;
    private String description;
    
    public Cinema(String p) {
    	String[] temp = p.split(" ");
    	this.cinemaID = Integer.parseInt(temp[0]);
    	this.row = Integer.parseInt(temp[1]);
    	this.column = Integer.parseInt(temp[2]);
    	this.classOfCinema = temp[3];
    	this.locationOfCinema = temp[4];
    	this.description = temp[5];
    }
    
    public boolean setCinemaID(Integer cinemaID) {
        this.cinemaID = cinemaID;
        return true;
    }

    public Integer getCinemaID() {
        return this.cinemaID;
    }

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
    
    public boolean setDescription(String description) {
    	this.description = description;
		return true;
    }

    public String getDescription() {
        return this.description;
    }

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
