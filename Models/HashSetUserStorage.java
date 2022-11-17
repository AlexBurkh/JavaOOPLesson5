package Models;

import lib.User;

import java.util.HashSet;
import java.util.Set;

public class ListUserStorage implements UserStorage {
    private Set<User> users;

    public ListUserStorage(Set<User> users) {
        this.users = users;
    }

    public ListUserStorage() {
        this.users = new HashSet<>();
    }

    @Override
    public void addUser(String username, String password) {

    }

    @Override
    public User findUser(String username) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }
}
