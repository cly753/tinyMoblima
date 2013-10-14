class Moviegoer {
    private String name;
    private String mobileNumber;
    private String emailAddress;
    private Integer age;
    private Ticket history[];

    public Moviegoer() {

    }

    public String getName() {
        return name;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public Integer getAge() {
        return age;
    }
    public Ticket[] getHistory() {
        return history;
    }
}