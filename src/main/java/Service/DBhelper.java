package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBhelper {

    private final static String SERVER_ADDRESS = "127.0.0.1:5432";
    private final static String DBNAME = "hw6";
    private final static String USER = "alireza";
    private final static String PASSWORD = "Alix0990#";

    private Connection connection ;



    public Connection Connect (){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://"+SERVER_ADDRESS+"/"+DBNAME,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }


}
