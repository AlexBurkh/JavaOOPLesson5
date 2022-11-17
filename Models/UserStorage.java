package Models;

import lib.User;

import java.util.Collection;

public interface UserStorage {
    void addUser(String username, String password);
    User findUser(String username);
    void deleteUser(User user);
    User[] getUsers();
}
