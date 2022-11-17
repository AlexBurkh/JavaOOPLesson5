import lib.User;

public interface Model {
    boolean checkPassword(String pass);
    void addUser(String username, String password);
    User findUser(String username);
    void deleteUser(User user);
}
