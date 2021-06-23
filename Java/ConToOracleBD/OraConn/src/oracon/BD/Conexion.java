package oracon.BD;

import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static Connection conn = null;
    private static String login = "oracle";
    private static String password = "123";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public static Connection getConnection() {

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, login, password);
            conn.setAutoCommit(false);

            if (conn != null)
            {
                System.out.println("Connection succes");

            } else
            {
                System.out.println("Connectionn denied");
            }

        } catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Connection denied" + e.getMessage() );
        }

        return conn;
    }

    public void disc() {
        try
        {
            conn.close();
            
        } catch (Exception e)
        {
            System.out.println("error al desconectar");
        }
    }
    
}
