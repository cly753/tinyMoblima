package Moblima;

import java.util.ArrayList;

class Moviegoer {
    private String name;
    private String mobileNumber;
    private String emailAddress;
    private Integer age;
    private ArrayList<Ticket> history;

    public Moviegoer() {

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

    public boolean setHistory(Ticket newTicket) {
        return history.add(newTicket);
    }
    public ArrayList<Ticket> getHistory() {
        return history;
    }

}
