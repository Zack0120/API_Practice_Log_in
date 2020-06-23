package tw.kewang.testserver.api;

public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verification(String username, String usernameDefault, String password, String passwordDefault){
        if(username.matches(usernameDefault)){
            if(password.matches(passwordDefault)){
                return true;
            }
        }

        return false;
    }
}
