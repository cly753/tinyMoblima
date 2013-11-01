package Moblima;

import java.util.*;
import java.io.*;

class Moviegoer extends User {
    private String name;
    private String mobileNumber;
    private String emailAddress;
    private Integer age;
    private ArrayList<Ticket> paid;
    private ArrayList<Ticket> unpaid;

    public Moviegoer(String username, String password, String name, String mobileNumber, String emailAddress, Integer age) {
        super(username, password);
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }
    public String getName() {
        return name;
    }

    public boolean setMoblieNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return true;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }

    public boolean setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return true;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public boolean setAge(Integer age) {
        this.age = age;
        return true;
    }
    public Integer getAge() {
        return age;
    }

    public boolean setPaid(Ticket newTicket) {
        paid.add(newTicket);
        return true;
    }
    public ArrayList<Ticket> getPaid() {
        return paid;
    }

    public boolean setUnpaid(Ticket newTicket) {
        unpaid.add(newTicket);
        return true;
    }
    public ArrayList<Ticket> getUnpaid() {
        return unpaid;
    }

}
