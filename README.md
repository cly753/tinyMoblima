##Y2S1CE2002PROJECT
***

---
###to be

    pls read Menu class first
- [ ✓ ] overall control
- [ ✓ ] list all/past movies
- [ ✓ ] show the detail of a movie
- [ ✓ ] book movie (show seats, get customer's info, reserve a movie)
- [ ✓ ] check history (not paid / all)
- [ ✓ ] check customer login
- [ ✓ ] check staff login
- [ ✓ ] change ticket price



---
###Movie Class

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
    private ArrayList<Time> showtimeList;
    private String rating;

    private static final String ratingList[] = {"G", "PG", "R18"};
    
    public Movie(String movieName, String typeOfMovie, String[] cast, String[] director, String language,
                  int runtime, String[] description, Time openingTime, Time[] showtimeList, String rating) {}

    public static Movie manualNewAMovie(Scanner sc) {}
    
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

    private boolean setMovieName(String movieName) {}
    private boolean setTypeOfMovie(String typeOfMovie) {}
    private boolean setCast(String[] cast) {}
    private boolean setDirector(String[] director) {}
    private boolean setLanguage(String language) {}
    private boolean setRuntime(int runtime) {}
    private boolean setDescription(String[] description) {}
    private boolean setOpeningTime(Time openingTime) {}
    private boolean addShowtime(Time newShowtime) {}
    private boolean deleteShowtime(Scanner sc) {}
    private boolean setRating(String rating) {}
    private boolean setRatingBB(Scanner sc) {}
}
```



---
###Moviegoer Class

```java
class Moviegoer {
    private String name;
    private String mobileNumber;
    private String emailAddress;
    private Integer age;
    private ArrayList<Ticket> history;

    public Moviegoer() {}

    public boolean setName(String name) {}
    public String getName() {}

    public boolean setMoblieNumber(String mobileNumber) {}
    public String getMobileNumber() {}

    public boolean setEmailAddress(String emailAddress) {}
    public String getEmailAddress() {}

    public boolean setAge(Integer age) {}
    public Integer getAge() {}

    public boolean setHistory(Ticket newTicket) {}
    public ArrayList<Ticket> getHistory() {}
}
```



---
###Time Class

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

    private static ArrayList<String> pubHoliList = new ArrayList<String>; // format: yyyymmdd
    private static ArrayList<String> weekendList = new ArrayList<String>; // format: yyyymmdd

    private boolean weekday;
    private boolean publicHoliday;

    public Time() {}
    public static Time manualNewATime(Scanner sc) {}

    public boolean storeCurrentTime() {}

    public boolean printTime() {}

    public boolean setYear(Integer year) {}
    public Integer getYear() {}
    public boolean setMonth(Integer month) {}
    public Integer getMonth() {}
    public boolean setDay(Integer date) {}
    public Integer getDay() {}
    public boolean setHour(Integer hour) {}
    public Integer getHour() {}
    public boolean setMinute(Integer minute) {}
    public Integer getMinute() {}
    public boolean setWeekday(boolean weekday) {}
    public boolean getWeekday() {}
    public boolean setPublicHoliday(boolean publicHoliday) {}
    public boolean getPublicHoliday() {}

    public boolean updatePubHoliAndWkend() {}
}
```



---
###Seat Class

```java
class Seat {
    private Integer row;
    private Integer no;
    private boolean assign;
    //private Integer moviegoerId;
    
    public Seat(Integer row, Integer no) {}

    public boolean setRow(Integer row) {}
    public Integer getRow() {}
    public boolean setNo(Integer no) {}
    public Integer getNo() {}
    public boolean assign() {}
    public boolean unAssign() {}
    public boolean getAssign() {}
    // public boolean setMoviegoerId(boolean id) {}
}
```



---
###Ticket Class

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
                  String typeOfMoviegoer, Time showTime, int seatID, int ticketID) {}
        
    private String getMovieName() {}
    private String getTypeOfMovie() {}
    private String getClassOfCinema() {}
    private String getLocationOfCinema() {}
    private String getTypeOfMoviegoer() {}
    private Time getShowTime() {}
    private double getPrice() {}
    private int getSeatID() {}
    private int getTicketID() {}
    
    private boolean setMovieName(String movieName) {}
    private boolean setTypeOfMovie(String typeOfMovie) {}
    private boolean setClassOfCinema(String classOfCinema) {}
    private boolean setLocationOfCinema(String locationOfCinema) {}
    private boolean setTypeOfMoviegoer(String typeOfMoviegoer) {}
    private boolean setShowTime(Time showTime) {}
    private boolean setSeatID(int seatID) {}
    private boolean setTicketID(int ticketID) {}

    private booean setPrice(){}
    //price is set according to typeOfMoviegoer typeOfMovie and showTime
}
```



---
###Menu class
    a rough menu and suggested action after select
```java
class Menu {
    public static void welcome() {}
    public static void toplevel() {}
    public static void staffMenu() {}
    public static void addModifyRemove() {}
    public static void modify() {}
}
```



---
###Cinema class
```java
class Cinema {
    private final Integer row;
    private final Integer column;
    private Seat theSeat[][];
    private static final String allClass[] = {"Normal", "Platinum"};
    private Integer theClass;

    public Cinema() {}

    public boolean setClass(Integer theClass) {}
    public Integer getClass() {}

    public boolean assignSeat(Integer row, Integer column) {}
    public boolean unAssignSeat(Integer row, Integer column) {}
    public boolean getSeatStatus(Integer row, Integer column) {}
}
```



---
###Cineplex class
```java
class Cineplex {
    private Cinema theCinema[];
    private String info[];
    //private static String infoField[] = {"Name", "Location", "CineplexId"};
}
```



---
###MovieLib class
```java
class MovieLib {
    private ArrayList<Movie> lib;
    
    public MovieLib() {}

    public static Movie[] searchMovie(MovieLib lib, String query) {}
    public static boolean add(MovieLib lib, Scanner sc) {}
    public static boolean remove(MovieLib lib, String movieName) {}
    public static boolean modify(MovieLib lib, String movieName, Integer choice, Scanner sc) {}
    public static void listMovie(MovieLib lib, Scanner sc) {}
}
```
