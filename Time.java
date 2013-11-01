package Moblima;

import java.util.*;
import java.io.*;

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

    private static ArrayList<String> pubHoliList = new ArrayList<String>();
    // format: yyyymmdd
    private static ArrayList<String> weekendList = new ArrayList<String>();
    // format: yyyymmdd

    private boolean weekday;
    private boolean publicHoliday;
    public Time() {

    }
    //=================
    //Error
    //=================
    //Cannot be used at MovieLib.java line 64, 68 134,..
    public static Time manualNewATime(Scanner sc) {
        Time newTime = new Time();
        newTime.setYear(sc.nextInt());
        newTime.setMonth(sc.nextInt());
        newTime.setDay(sc.nextInt());
        newTime.setHour(sc.nextInt());
        newTime.setMinute(sc.nextInt());

        return newTime;
    }

    public Time storeCurrentTime() {
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

        return this;
    }

    public boolean printTime() {
        System.out.format("%2d %s %4d\n   %2d:%2d", day,
                        strMonth[month], year, hour, minute);
    }

    public boolean setYear(Integer year) {
        this.year = year;
        updatePubHoliAndWkend();
        return true;
    }
    public Integer getYear() {
        return year;
    }

    public boolean setMonth(Integer month) {
        this.month = month;
        updatePubHoliAndWkend();
        return true;
    }
    public Integer getMonth() {
        return month;
    }

    public boolean setDay(Integer date) {
        this.date = date;
        updatePubHoliAndWkend();
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

    public static boolean setPublicHoliday(String publicHoliday) {
        pubHoliList.add(publicHoliday);
        return true;
    }
    public static boolean getPublicHoliday() {
        return pubHoliList;
    }


    public boolean updatePubHoliAndWkend() {
        String timeStr = Integer.toString(this.year) + Integer.toString(this.month) + Integer.toString(this.day);

        for (int i = 0; i < pubHoliList.size(); i++) {
            if (pubHoliList.get(i).compareTo(timeStr) == 0){
                publicHoliday = true;
            }
        }
        for (int i = 0; i < weekendList.size(); i++) {
            if (weekendList.get(i).compareTo(timeStr) == 0){
                this.setWeekday(false);
            }
        }
    }
}
