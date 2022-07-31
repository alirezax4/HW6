package Service;

import Repository.UserRepository;
import Service.Menu.UserMenu;

import java.sql.Connection;
import java.util.Scanner;

public class ApplicationConstant {

    private static Scanner input = new Scanner(System.in);

    public static Scanner getInput() {
        return input;
    }

    public static final String[] USER_MENU = {"login","signup","exit"};

    private static UserMenu userMenu = new UserMenu();

    public static UserMenu getUserMenu() {
        return userMenu;
    }

    public static void setUserMenu(UserMenu userMenu) {
        ApplicationConstant.userMenu = userMenu;
    }

    private static Connection connection = new Service.DBhelper().Connect();
    private static UserRepository userRepository = new UserRepository();

    public static Connection getConnection() {
        return connection;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }
}
