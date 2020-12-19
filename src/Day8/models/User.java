package Day8.models;

public class User {
    private String full_name;
    private String username;
    private String email;
    private String password;

    public User(String full_name, String username, String email, String password) {
        this.full_name = full_name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
