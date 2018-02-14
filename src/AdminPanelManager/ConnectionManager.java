package AdminPanelManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager  {
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String driverName = "oracle.jdbc.driver.OracleDriver";
    private static String username = "system";
    private static String password = "admin";
    private static Connection con;

    public static Connection getConnection() {

        try {

            Class.forName(driverName);

            try {

                con = DriverManager.getConnection(url, username, password);
                // System.out.println("Connection Sucessfull.");

            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
            System.exit(1);

        }
        return con;
    }
    public static void close(){
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println("connection cant be closed");

            e.printStackTrace();
        }
    }
}
