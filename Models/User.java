package Models;

import java.util.Objects;

public class User {
    private String username;
    private int passwordHash;


    // Constructors
    public User(String username, int passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }


    // Override
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + passwordHash + '\'' +
                ", salt=" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        User another;
        if (o instanceof User) {
            another = (User) o;
            return username.equals(another.username);
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
    public int getPasswordHash() {
        return passwordHash;
    }
}
