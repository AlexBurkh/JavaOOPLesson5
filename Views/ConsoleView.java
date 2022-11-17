package Views;

import java.util.Map;
import java.util.Scanner;

public class ConsoleView implements View {
    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String s) {
        System.out.print(s);
    }

    @Override
    public void println(String s) {
        System.out.println(s);
    }

    @Override
    public int menu(Map<Integer, String> menuPoints) {
        println("Доброго времени суток! Выберите пункт меню");
        println("\t1 - " + menuPoints.get(1));
        println("\t2 - " + menuPoints.get(2));
        println("\t3 - " + menuPoints.get(3));
        String point =  get("Пункт меню > ");
        return Integer.parseInt(point);
    }

    @Override
    public String getLine(String textToPrintBefore) {
        String result = "";
        print(textToPrintBefore);
        while (result.length() == 0) {
            result = sc.nextLine();
        }
        return result;
    }

    @Override
    public String get(String textToPrintBefore) {
        println("");
        print(textToPrintBefore);
        return sc.next();
    }


}
