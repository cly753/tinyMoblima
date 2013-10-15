Y2S1CE2002PROJECT
=================



Movie Class
-----------

```java
class Movie {
    private String movieName;
    private String typeOfMovie;
    private String[] cast;
    private String[] director;
    private String language;
    private int runtime;
    private String[] description;
    private Time openingTime;
    private Time[] showtimeList;
    private String rating;
    
    public Movie(String movieName, String typeOfMovie, String[] cast, String[] director, String language,
                  int runtime, String[] description, Time openingTime, Time[] showtimeList, String rating) {}
    
    private String getMovieName() {}
    private String getTypeOfMovie() {}
    private String[] getCast() {}
    private String[] getDirector() {}
    private String getLanguage() {}
    private int getRuntime() {}
    private String[] getDescription() {}
    private Time getOpeningTime() {}
    private Time[] getShowtimeList() {}
    private String getRating() {}

    private void setMovieName(String movieName) {}
    private void setTypeOfMovie(String typeOfMovie) {}
    private void setCast(String[] cast) {}
    private void setDirector(String[] director) {}
    private void setLanguage(String language) {}
    private void setRuntime(int runtime) {}
    private void setDescription(String[] description) {}
    private void setOpeningTime(Time openingTime) {}
    private void setShowtimeList(Time[] showtimeList) {}
    private void setRating(String rating) {}
}
```


Moviegoer Class
---------------

```java
class Moviegoer {
    private String name;
    private String mobileNumber;
    private String emailAddress;
    private Integer age;
    private ArrayList<Ticket> history;
    
    public Moviegoer(){}
    
    public boolean setName(String name){}
    public String getName(){}
    public boolean setMoblieNumber(String mobileNumber){}
    public String getMobileNumber(){}
    public boolean setEmailAddress(String emailAddress){}
    public String getEmailAddress(){}
    public boolean setAge(Integer age){}
    public Integer getAge(){}
    public boolean setHistory(Ticket newTicket){}
    public ArrayList<Ticket> getHistory(){}
}
```


Time Class
----------

```java
class Time {
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;

    private static final String strMonth[] = {"JAN", "FEB", "MAR",
                                            "APR", "MAY", "JUN",
                                            "JUL", "AUG", "SEP",
                                            "OCT", "NOV", "DEC"};

    private boolean weekday;
    private boolean publicHoliday;

    public Time(){}

    public boolean storeCurrentTime(){}
    public boolean printTime(){}

    public boolean setYear(Integer year){}
    public Integer getYear(){}
    public boolean setMonth(Integer month){}
    public Integer getMonth(){}
    public boolean setDay(Integer date){}
    public Integer getDay(){}
    public boolean setHour(Integer hour){}
    public Integer getHour(){}
    public boolean setMinute(Integer minute){}
    public Integer getMinute(){}
    public boolean setWeekday(boolean weekday){}
    public boolean getWeekday(){}
    public boolean setPublicHoliday(boolean publicHoliday){}
    public boolean getPublicHoliday(){}
}
```


Seat Class
----------

```java
class Seat {
    private Integer row;
    private Integer no;
    private boolean assign;
    //private Integer moviegoerId;
    
    public Seat(){}

    public boolean setRow(Integer row){}
    public Integer getRow(){}
    public boolean setNo(Integer no){}
    public Integer getNo(){}
    public boolean setAssign(boolean assign){}
    public boolean getAssign(){}
    // public boolean setMoviegoerId(boolean id){}
    // public Integer getMoviegoerId(){}
}
```


Ticket Class
------------

```java
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
                  String typeOfMoviegoer, Time showTime, double price, int seatID, int ticketID) {}
        
    private String getMovieName() {}
    private String getTypeOfMovie() {}
    private String getClassOfCinema() {}
    private String getLocationOfCinema() {}
    private String getTypeOfMoviegoer() {}
    private Time getShowTime() {}
    private double getPrice() {}
    private int getSeatID() {}
    private int getTicketID() {}
    
    private void setMovieName(String movieName) {}
    private void setTypeOfMovie(String typeOfMovie) {}
    private void setClassOfCinema(String classOfCinema) {}
    private void setLocationOfCinema(String locationOfCinema) {}
    private void setTypeOfMoviegoer(String typeOfMoviegoer) {}
    private void setShowTime(Time showTime) {}
    private void setPrice(double price) {}
    private void setSeatID(int seatID) {}
    private void setTicketID(int ticketID) {}
}
```
