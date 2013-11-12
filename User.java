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
    public String getUsernameWelcome() {
        String tmp = "";
        for (int i = 0; i < username.length(); i++) {
            if (tmp.length() >= 7) break;
            tmp += username.charAt(i);
        }
        while (tmp.length() < 7) {
            tmp += " ";
        }
        return tmp;
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
