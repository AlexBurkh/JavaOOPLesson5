package Models;

import lib.User;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetUserStorage implements UserStorage {
    private Set<User> users;


    // Constructors
    public HashSetUserStorage(Set<User> users) {
        this.users = users;
    }

    public HashSetUserStorage() {
        this.users = new HashSet<>();
    }


    // Override
    @Override
    public boolean addUser(String username, String cleartextPassword) {
        int hash = hashPassword(cleartextPassword);
        User u = new User(username, hash);
        if (users.add(u)) {
            return true;
        }
        return false;
    }
    @Override
    public User findUser(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }
    @Override
    public User[] getUsers() {
        return (User[]) users.toArray();
    }


    // Methods
    public int hashPassword(String cleartextPassword) {
        return Objects.hash(cleartextPassword);
    }
}
