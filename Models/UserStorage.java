package Models;

import lib.User;

public interface UserStorage {
    boolean addUser(String username, String password);
    User findUser(String username);
    void deleteUser(User user);
    User[] getUsers();
    int hashPassword(String pass);
}
