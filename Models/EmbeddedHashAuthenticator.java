package Models;

import java.util.Objects;

public class EmbeddedHashAuthenticator implements HashAuthenticator {
    @Override
    public int hash(String text) {
        return Objects.hash(text);
    }

    @Override
    public boolean authenticate(int hash, String password) {
        return hash == hash(password);
    }
}
