package Models;

public interface HashAuthenticator {
    public int hash(String text);
    public boolean authenticate(int hash, String password);
}
