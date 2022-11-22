package Models;

public interface UserStorage {
    boolean addUser(String username, String password);
    User findUser(String username);
    void deleteUser(User user);
    User[] getUsers();
}
