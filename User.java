package Moblima;

class User {
    private String password;
    private String username;

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public boolean setPassword(String password) {
        this.password = password;
        return true;
    }
    public boolean setUsername(String username) {
        this.username = username;
        return true;
    }
}
