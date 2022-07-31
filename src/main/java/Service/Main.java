package Service;

import Entity.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

      //  ApplicationConstant.getConnection(); //test connection to db
/*
        User u1 = new User(-1,"alix","0016944976","1373-03-07","Alix0990#");
        User u2 = new User(-1,"shjk","0029871234","1366-08-22","shjk0919");
        User u3 = new User(-1,"elix","0035672349","1375-02-09","elix0912");
        User u4 = new User(-1,"zaaahra","0057771233","1375-02-17","zaahra0936");
        User u5 = new User(-1,"barooon","0024321675","1360-11-10","baroon0912");
        User u6 = new User(-1,"alirezaxmz","0015678943","1373-03-07","alirezaxmz0937");
        ApplicationConstant.getUserRepository().createUser(u1);
        ApplicationConstant.getUserRepository().createUser(u2);
        ApplicationConstant.getUserRepository().createUser(u3);
        ApplicationConstant.getUserRepository().createUser(u4);
        ApplicationConstant.getUserRepository().createUser(u5);
        ApplicationConstant.getUserRepository().createUser(u6);

 */

        ApplicationConstant.getUserRepository().deleteUser(1);
        ApplicationConstant.getUserRepository().deleteUser(2);
        ApplicationConstant.getUserRepository().deleteUser(3);
        ApplicationConstant.getUserRepository().deleteUser(4);
        ApplicationConstant.getUserRepository().deleteUser(5);
        ApplicationConstant.getUserRepository().deleteUser(6);



      //ApplicationConstant.getUserMenu().runFirstMenu();

    }
}
