package Moblima;

import java.util.*;

class Moviegoer extends User {

    private String name;
    private String mobileNumber;
    private String emailAddress;
    private Integer age;
    private ArrayList<Integer> paid; // goer only store ticketID
    private ArrayList<Integer> unpaid;

    public Moviegoer(String username, String password, String name, String mobileNumber, String emailAddress, Integer age) {
        super(username, password);
        paid = new ArrayList<Integer>();
        unpaid = new ArrayList<Integer>();
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

    public boolean setMobileNumber(String mobileNumber) {
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

    public boolean setPaid(Integer newTicketID) {
        paid.add(newTicketID);
        return true;
    }

    public ArrayList<Integer> getPaid() {
        return paid;
    }

    public boolean setUnpaid(Integer newTicketID) {
        unpaid.add(newTicketID);
        return true;
    }

    public ArrayList<Integer> getUnpaid() {
        return unpaid;
    }

    public String getTypeOfMoviegoer() {
        if (age < 18) {
            return "Student";
        } else {
            if (age > 65) {
                return "Senior Citizen";
            }
        }
        return "others";
    }
}
