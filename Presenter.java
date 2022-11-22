import Models.*;
import Views.View;
import Views.ConsoleView;

import java.util.HashMap;
import java.util.Map;

public class Presenter {
    private UserStorage userStorage;
    private View ui;
    private Map<Integer, String> menuPoints;
    private HashAuthenticator authenticator;


    public Presenter(UserStorage userStorage, View ui, Map<Integer, String> menuPoints, HashAuthenticator authenticator) {
        this.userStorage = userStorage;
        this.ui = ui;
        this.menuPoints = menuPoints;
        this.authenticator = authenticator;
        if (menuPoints.size() <= 0) {
            menuPoints.put(1, "Вход");
            menuPoints.put(2, "Регистрация");
            menuPoints.put(3, "Выход");
        }
    }
    public Presenter(View ui, Map<Integer, String> menuPoints, HashAuthenticator authenticator) {
        this(new HashSetUserStorage(authenticator), ui, menuPoints, authenticator);
    }

    public Presenter() {
        this(new ConsoleView(), new HashMap<>(), new EmbeddedHashAuthenticator());
    }

    void start() {
        boolean flag = true;
        while(flag) {
            int p = ui.menu(menuPoints);

            switch (p) {
                case 1 -> {
                    var username = ui.getLine("Введите имя пользователя: ");
                    var password = ui.getLine("Введите пароль: ");
                    if (authenticator.authenticate(userStorage.findUser(username).getPasswordHash(), password)) {
                        ui.println("Поздравляю, аутентификация пройдена");
                    } else {
                        ui.println("Неудачная попытка аутентификации");
                    }
                }
                case 2 -> {
                    String username = ui.getLine("Введите имя пользователя: ");
                    String password = ui.getLine("Введите пароль: ");
                    if (userStorage.addUser(username, password)) {
                        ui.println("Пользователь зарегистрирован");
                    }
                    else {
                        ui.println("Не удалось добавить пользователя");
                    }

                }
                case 3 -> {
                    ui.println("До свидания");
                    flag = false;
                }
                default -> {
                    ui.println("Некорректный пункт меню");
                }
            }
        }
    }
}
