package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {
    public Connection connectToDb() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "root";
        String password = "pass";

        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
