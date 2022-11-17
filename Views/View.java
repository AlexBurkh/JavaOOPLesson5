package Views;

import java.util.Map;

public interface View {
    void print(String s);
    void println(String s);
    int menu(Map<Integer, String> menuPoints);
    String getLine(String textToPrintBefore);
    String get(String textToPrintBefore);
}
