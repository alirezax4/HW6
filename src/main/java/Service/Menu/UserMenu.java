package Service.Menu;

import Entity.User;
import Repository.UserRepository;
import Service.ApplicationConstant;
import Service.Printer;

import java.sql.SQLException;

public class UserMenu {

    public void runFirstMenu() throws SQLException {
        System.out.println("WELCOME");

        while (true) {
            Printer.print(ApplicationConstant.USER_MENU);
            System.out.println("enter your item");
            int input = ApplicationConstant.getInput().nextInt();

            switch (input) {
                case 1:
                    login();
                    break;

                case 2:
                    signup();
                    break;

                case 3:
                    System.exit(1);
                    break;

                default:
                    System.out.println("enter correct number of menu");
            }

        }

    }

    public void login() throws SQLException {
        User user =new User();
        System.out.println("enter username");
        String inputUserName = ApplicationConstant.getInput().next();
        System.out.println("enter password");
        String inputPassword = ApplicationConstant.getInput().next();
        if (ApplicationConstant.getUserRepository().isUsernameExist(inputUserName)){
            user = ApplicationConstant.getUserRepository().findUserByUsername(inputUserName);
            if (user.getPassword().equals(inputPassword)){
                System.out.println("welcome "+user.getUserName());
            }
        }else {
            System.out.println("username or password is not correct");
        }
    }

    public void signup() throws SQLException {
        User user = new User();
        String inputUserName;
        while (true) {
            System.out.println("enter username");
            inputUserName = ApplicationConstant.getInput().next();
            if(ApplicationConstant.getUserRepository().isUsernameExist(inputUserName)){
                continue;
            }else{
                user.setUserName(inputUserName);
                break;
            }
        }

        System.out.println("enter national code");
        String nationalPassword = ApplicationConstant.getInput().next();
        user.setNationalCode(nationalPassword);

        System.out.println("enter birthday");
        user.setBirthDay(ApplicationConstant.getInput().next());

        System.out.println("password is your national code ");
        user.setPassword(nationalPassword);


        ApplicationConstant.getUserRepository().createUser(user);




    }
}
