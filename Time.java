import java.util.Calendar;

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

    public time() {

    }

    public boolean storeCurrentTime() {
        this.year = Calendar.get(YEAR);
        this.month = Calendar.get(MONTH);
        this.day = Calendar.get(DATE);
        this.hour = Calendar.get(HOUR);
        this.minute = Calendar.get(MINUTE);
        if (DAY_OF_WEEK != 1 && DAY_OF_WEEK != 7)
            weekday = true;
        else
            weekday = false;

        publicHoliday = false;

        return true;
    }

    public boolean printTime() {
        System.out.format("%2d %s %4d\n   %2d:%2d", day,
                        strMonth[month], year, hour, minute);
    }

    public boolean setYear(Integer year) {
        this.year = year;
        return true;
    }
    public Integer getYear() {
        return year;
    }

    public boolean setMonth(Integer month) {
        this.month = month;
        return true;
    }
    public Integer getMonth() {
        return month;
    }

    public boolean setDay(Integer date) {
        this.date = date;
        return true;
    }
    public Integer getDay() {
        return day;
    }

    public boolean setHour(Integer hour) {
        this.hour = hour;
        return true;
    }
    public Integer getHour() {
        return hour;
    }

    public boolean setMinute(Integer minute) {
        this.minute = minute;
        return true;
    }
    public Integer getMinute() {
        return minute;
    }

    public boolean setWeekday(boolean weekday) {
        this.weekday = weekday;
        return true;
    }
    public boolean getWeekday() {
        return weekday;
    }

    public boolean setPublicHoliday(boolean publicHoliday) {
        this.publicHoliday = publicHoliday;
        return true;
    }
    public boolean getPublicHoliday() {
        return publicHoliday;
    }
}