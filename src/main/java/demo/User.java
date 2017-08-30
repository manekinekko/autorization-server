package demo;

public class User {
    private String username;

    private String email;

    private String name;

    private String firstname;

    private String lastname;

    public User(String username, String firstname, String lastname, String name, String email) {
        this.username = username;
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.name = name;
    }

    public User() {
        this("user", "Stephen", "Job", "Stephen Jobs", "sncf.ietr@gmail.com");
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{}";
    }
}