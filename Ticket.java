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
                  String typeOfMoviegoer, Time showTime, double price, int seatID, int ticketID) {
        this.setMovieName(movieName);
        this.setTypeOfMovie(typeOfMovieg);
        this.setClassOfCinema(classOfCinema);
        this.setLocationOfCinema(locationOfCinema);
        this.setTypeOfMoviegoer(typeOfMoviegoer);
        this.setShowTime(showTime);
        this.setPrice(price);
        this.setSeatID(seatID);
        this.setTicketID(ticketID);
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
    }
    private boolean setTypeOfMovie(String typeOfMovie) {
        this.typeOfMovie = typeOfMovie;
    }
    private boolean setClassOfCinema(String classOfCinema) {
        this.classOfCinema = classOfCinema;
    }
    private boolean setLocationOfCinema(String locationOfCinema) {
        this.locationOfCinema = locationOfCinema;
    }
    private boolean setTypeOfMoviegoer(String typeOfMoviegoer) {
        this.typeOfMoviegoer = typeOfMoviegoer;
    }
    private boolean setShowTime(Time showTime) {
        this.showTime = showTime;
    }
    private boolean setPrice(double price) {
        this.price = price;
    }
    private boolean setSeatID(int seatID) {
        this.seatID = seatID;
    }
    private boolean setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }    
}
