Y2S1CE2002PROJECT
=================

Movie Class
-----------
```java
    String movieName,
    String typeOfMovie,
    String[] cast,
    String[] director,
    String language,
    int runtime,
    String[] description,
    Time openingTime,
    Time[] showtimeList,
    String rating
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

    public time(){}

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
