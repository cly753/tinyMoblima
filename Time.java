package Moblima;

import java.util.*;
import java.io.*;

class Time {

    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private boolean weekday;
    private boolean publicHoliday;
    
    private static final String strMonth[] = {"JAN", "FEB", "MAR",
        "APR", "MAY", "JUN",
        "JUL", "AUG", "SEP",
        "OCT", "NOV", "DEC"};

    private static ArrayList<String> pubHoliList = new ArrayList<String>();
    // format: yyyymmdd
    private static ArrayList<String> weekendList = new ArrayList<String>();
    // format: yyyymmdd



    public Time() {

    }
    
    public Time(String time) {
    	String[] value = time.split(" ");
    	
    	year = Integer.parseInt(value[0]);
    	month = Integer.parseInt(value[1]);
    	day = Integer.parseInt(value[2]);
    	hour = Integer.parseInt(value[3]);
    	minute = Integer.parseInt(value[4]);
    	
    	weekday = false;
    	if (value[5].compareTo("true") == 0)
    		weekday = true;
    	
    	publicHoliday = false;
    	if (value[6].compareTo("true") == 0)
    		publicHoliday = true;
    	
    }

    //=================
    //Error
    //=================
    //Cannot be used at MovieLib.java line 64, 68 134,..
    public static Time manualNewATime() {
        Scanner sc = new Scanner(System.in);
        Time newTime = new Time();
        System.out.println("Please enter year: ");
        newTime.setYear(sc.nextInt());
        System.out.println("Please enter month: 1~12:");
        newTime.setMonth(sc.nextInt());
        System.out.println("Please enter day:");
        newTime.setDay(sc.nextInt());
        System.out.println("Please enter hour: 0~23");
        newTime.setHour(sc.nextInt());
        System.out.println("Please enter minute: 0~59");
        newTime.setMinute(sc.nextInt());

        return newTime;
    }

    public Time storeCurrentTime() {
        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH);
        this.day = Calendar.getInstance().get(Calendar.DATE);
        this.hour = Calendar.getInstance().get(Calendar.HOUR);
        this.minute = Calendar.getInstance().get(Calendar.MINUTE);
        if (Calendar.DAY_OF_WEEK != 1 && Calendar.DAY_OF_WEEK != 7) {
            weekday = true;
        } else {
            weekday = false;
        }

        publicHoliday = false;

        return this;
    }

    public void printTime() {
        System.out.format("%2d %s %4d\n   %2d:%2d", day,
                strMonth[month], year, hour, minute);
    }

    public String getStr() {
        String str = String.format("%2d %s %4d\n   %2d:%2d", day,
                strMonth[month], year, hour, minute);
        return str;
    }
    
    public String toString() {
    	return String.format("%s %s %s %s %s %s %s", year.toString(), month.toString(), day.toString(), hour.toString(), minute.toString(), String.valueOf(weekday), String.valueOf(publicHoliday));
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

    public boolean setDay(Integer day) {
        this.day = day;
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

    public static ArrayList<String> getPublicHoliday() {
        return pubHoliList;
    }

    public void updatePubHoliAndWkend() {
        String timeStr = Integer.toString(this.year) + Integer.toString(this.month) + Integer.toString(this.day);

        for (int i = 0; i < pubHoliList.size(); i++) {
            if (pubHoliList.get(i).compareTo(timeStr) == 0) {
                publicHoliday = true;
            }
        }
        for (int i = 0; i < weekendList.size(); i++) {
            if (weekendList.get(i).compareTo(timeStr) == 0) {
                this.setWeekday(false);
            }
        }
    }
}
