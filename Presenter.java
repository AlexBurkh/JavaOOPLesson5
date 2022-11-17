import Models.UserStorage;
import Views.View;

import Views.ConsoleView;
import Models.HashSetUserStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Presenter {
    private UserStorage userStorage;
    private View ui;
    private Map<Integer, String> menuPoints;



    public Presenter(UserStorage userStorage, View ui, Map<Integer, String> menuPoints) {
        this.userStorage = userStorage;
        this.ui = ui;
        this.menuPoints = menuPoints;
    }

    public Presenter() {
        this(new HashSetUserStorage(), new ConsoleView(), new HashMap<>());
        menuPoints.put(1, "Вход");
        menuPoints.put(2, "Регистрация");
        menuPoints.put(3, "Выход");
    }

    void start() {
        boolean flag = true;
        while(flag) {
            int p = ui.menu(menuPoints);

            switch (p) {
                case 1 -> {
                    var username = ui.getLine("Введите имя пользователя: ");
                    var password = ui.getLine("Введите пароль: ");
                    if (authenticate(username, password)) {
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

    boolean authenticate(String username, String password) {
        int hash = userStorage.hashPassword(password);
        if (userStorage.findUser(username).getPasswordHash() == hash) {
            return true;
        }
        return false;
    }
}
