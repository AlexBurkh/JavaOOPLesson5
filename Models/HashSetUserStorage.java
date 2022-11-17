package Models;

import lib.User;

import java.util.HashSet;
import java.util.Set;

public class HashSetUserStorage implements UserStorage {
    private Set<User> users;

    public HashSetUserStorage(Set<User> users) {
        this.users = users;
    }

    public HashSetUserStorage() {
        this.users = new HashSet<>();
    }

    @Override
    public void addUser(String username, String password) {
        users.add(new User(username, password));
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
}
