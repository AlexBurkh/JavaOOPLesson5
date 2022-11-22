package Models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetUserStorage implements UserStorage {
    private Set<User> users;
    private HashAuthenticator authenticator;


    // Constructors
    public HashSetUserStorage(Set<User> users, HashAuthenticator authenticator) {
        this.users = users;
        this.authenticator = authenticator;
    }

    public HashSetUserStorage(HashAuthenticator authenticator) {
        this.users = new HashSet<>();
        this.authenticator = new EmbeddedHashAuthenticator();
    }


    // Override
    @Override
    public boolean addUser(String username, String cleartextPassword) {
        int hash = authenticator.hash(cleartextPassword);
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
}
