package Moblima;

class Ticket {
    //private int movieId;
    private String movieName;
    private String typeOfMovie;
    private String classOfCinema;
    private String locationOfCinema;
    private String typeOfMoviegoer;
    //private Time buyTime;
    //private Time bookTime;
    private Time showTime;
    private double price;
    private int seatID;
    private int ticketID;
    
    public Ticket(String movieName, String typeOfMovie, String classOfCinema, String locationOfCinema,
                  String typeOfMoviegoer, Time showTime, int seatID, int ticketID) {
        this.setMovieName(movieName);
        this.setTypeOfMovie(typeOfMovie);
        this.setClassOfCinema(classOfCinema);
        this.setLocationOfCinema(locationOfCinema);
        this.setTypeOfMoviegoer(typeOfMoviegoer);
        this.setShowTime(showTime);
        this.setSeatID(seatID);
        this.setTicketID(ticketID);

        this.setPrice();
    }
    
    private String getMovieName() {
        return this.movieName;
    }
    private String getTypeOfMovie() {
        return this.typeOfMovie;
    }
    private String getClassOfCinema() {
        return this.classOfCinema;
    }
    private String getLocationOfCinema() {
        return this.locationOfCinema;
    }
    private String getTypeOfMoviegoer() {
        return this.typeOfMoviegoer;
    }
    private Time getShowTime() {
        return this.showTime;
    }
    private double getPrice() {
        return this.price;
    }
    private int getSeatID() {
        return this.seatID;
    }
    private int getTicketID() {
        return this.ticketID;
    }
    
    private boolean setMovieName(String movieName) {
        this.movieName = movieName;
        return true;
    }
    private boolean setTypeOfMovie(String typeOfMovie) {
        this.typeOfMovie = typeOfMovie;
        return true;
    }
    private boolean setClassOfCinema(String classOfCinema) {
        this.classOfCinema = classOfCinema;
        return true;
    }
    private boolean setLocationOfCinema(String locationOfCinema) {
        this.locationOfCinema = locationOfCinema;
        return true;
    }
    private boolean setTypeOfMoviegoer(String typeOfMoviegoer) {
        this.typeOfMoviegoer = typeOfMoviegoer;
        return true;
    }
    private boolean setShowTime(Time showTime) {
        this.showTime = showTime;
        return true;
    }
    private boolean setSeatID(int seatID) {
        this.seatID = seatID;
        return true;
    }
    private boolean setTicketID(int ticketID) {
        this.ticketID = ticketID;
        return true;
    }

    private boolean setPrice() {
        if (this.typeOfMoviegoer = "Senior Citizen") {
            if (this.typeOfMovie = "Digital Movie") {
                if(this.showTime.getWeekday()) {
                    this.price = 4;
                    return true;
                }
            }
        }
        if (this.typeOfMoviegoer = "Student") {
            if (this.typeOfMovie = "Digital Movie") {
                if (this.showTime.getWeekday()) {
                    this.price = 7;
                    return true;
                }
            } else {
                this.price = 9;
                return true;
            }
        }
        if (this.showTime.getWeekday()) {
            if (this.typeOfMovie = "Digital Movie") {
                this.price = 9.5;
            } else {
                this.price = 11;
            }
            return true;
        } else {
            if (this.typeOfMovie = "Digital Movie") {
                this.price = 11;
            } else {
                this.price = 15;
            }
            return true;
        }
    }
}
