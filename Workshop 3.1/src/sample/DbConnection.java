package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    //creating a connection coordinate where you can connect to it from anywhere, say another class, when working on a big project

    public static final String USERNAME="root";
    public static final String PASSWORD ="";
    public static final String CONN ="jdbc:mysql://localhost:3308/travelexperts";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN, USERNAME, PASSWORD);
    }


}


