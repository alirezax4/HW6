package Service;

import java.sql.Connection;

public class ApplicationConstant {

    private static Connection connection = new DBhelper().Connect();

    public static Connection getConnection() {
        return connection;
    }
}
