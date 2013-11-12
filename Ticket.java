package Moblima;

class Ticket {
    private String movieName;
    private String typeOfMovie;
    private Integer cinemaID;
    private String classOfCinema;
    private String locationOfCineplex;
    private String typeOfMoviegoer;
    private Time buyTime;
    private Time bookTime;
    private Time showtime;
    private double price;
    private Integer seatRow;
    private Integer seatColumn;
    private Integer ticketID;

    public Ticket() {
        ;
    }
    public Ticket(String movieName, String typeOfMovie, Integer cinemaID, String classOfCinema, String locationOfCineplex,
            String typeOfMoviegoer, Time buyTime, Time bookTime, Time showtime, Integer row, Integer col, Integer ticketID) {
        this.setMovieName(movieName);
        this.setTypeOfMovie(typeOfMovie);
        this.setCinemaID(cinemaID);
        this.setClassOfCinema(classOfCinema);
        this.setLocationOfCineplex(locationOfCineplex);
        this.setTypeOfMoviegoer(typeOfMoviegoer);
        this.setBookTime(bookTime);
        this.setBuyTime(buyTime);
        this.setShowtime(showtime);
        this.setSeatRow(row);
        this.setSeatCol(col);
        this.setTicketID(ticketID);
        this.setPrice();
    }

    public String getMovieName() {
        return this.movieName;
    }

    public String getTypeOfMovie() {
        return this.typeOfMovie;
    }

    public Integer getCinemaID() {
        return this.cinemaID;
    }

    public String getClassOfCinema() {
        return this.classOfCinema;
    }

    public String getLocationOfCineplex() {
        return this.locationOfCineplex;
    }

    public String getTypeOfMoviegoer() {
        return this.typeOfMoviegoer;
    }
    
    public double getPrice() {
        return this.price;
    }

    public Integer getSeatRow() {
        return this.seatRow;
    }

    public Integer getSeatColumn() {
        return this.seatColumn;
    }

    public Integer getTicketID() {
        return this.ticketID;
    }

    public Time getShowtime() {
        return showtime;
    }
    public Time getBookTime() {
    	return bookTime;
    }
    
    public Time getBuyTime() {
        return buyTime;
    }

    public boolean setMovieName(String movieName) {
        this.movieName = movieName;
        return true;
    }

    public boolean setTypeOfMovie(String typeOfMovie) {
        this.typeOfMovie = typeOfMovie;
        return true;
    }

    public boolean setCinemaID(Integer cinemaID) {
        this.cinemaID = cinemaID;
        return true;
    }

    public boolean setClassOfCinema(String classOfCinema) {
        this.classOfCinema = classOfCinema;
        return true;
    }

    public boolean setLocationOfCineplex(String locationOfCineplex) {
        this.locationOfCineplex = locationOfCineplex;
        return true;
    }

    public boolean setTypeOfMoviegoer(String typeOfMoviegoer) {
        this.typeOfMoviegoer = typeOfMoviegoer;
        return true;
    }

    public boolean setShowtime(Time showtime) {
        this.showtime = showtime;
        return true;
    }

    public boolean setSeatCol(Integer col) {
        this.seatColumn = col;
        return true;
    }

    public boolean setSeatRow(Integer row) {
        this.seatRow = row;
        return true;
    }

    public boolean setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
        return true;
    }

    public boolean setBookTime(Time bookTime) {
    	this.bookTime = bookTime;
    	return true;
    }
    
    public boolean setBuyTime(Time buyTime) {
        this.buyTime = buyTime;
        return true;
    }

    public boolean setPrice() {
        if (this.typeOfMoviegoer == "Senior Citizen") {
            if (this.typeOfMovie != "3D") {
                if (this.showtime.getWeekday()) {
                    this.price = 4;
                    return true;
                }
            }
        }
        if (this.typeOfMoviegoer == "Student") {
            if (this.typeOfMovie != "3D") {
                if (this.showtime.getWeekday()) {
                    this.price = 7;
                    return true;
                }
            } else {
                this.price = 9;
                return true;
            }
        }
        if (this.showtime.getWeekday()) {
            if (this.typeOfMovie != "3D") {
                this.price = 9.5;
            } else {
                this.price = 11;
            }
            return true;
        } else {
            if (this.typeOfMovie != "3D") {
                this.price = 11;
            } else {
                this.price = 15;
            }
            return true;
        }
    }

    public static void display(Ticket ti) {
        System.out.println(">============================<");
        System.out.println(">||" + ti.getMovieName() + " " + ti.getTypeOfMovie());
        System.out.println(">||" + ti.getShowtime());
        System.out.println(">||" + (ti.getSeatRow() + 1) + " " + (ti.getSeatColumn() + 1) + " " + ti.getTicketID() + " " + ti.getTypeOfMoviegoer());
        System.out.println(">||" + ti.getClassOfCinema() + " " + ti.getLocationOfCineplex());
        System.out.println(">||" + "price: " + ti.getPrice());
        System.out.println(">============================<");
    }
}
