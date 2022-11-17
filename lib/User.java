package lib;

import java.util.Objects;
import java.util.Random;

public class User {
    private String username;
    private String password;
    private int salt;

    private static final Random rnd = new Random();


    // Constructors
    public User(String username, String password, int salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;
    }
    public User(String username, String password) {
        this(username, password, rnd.nextInt());
    }


    // Override
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt=" + salt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        User another;
        if (o instanceof User) {
            another = (User) o;
            return username.equals(another.username) && password.equals(another.password);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    // Getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int getSalt() {
        return salt;
    }
}
