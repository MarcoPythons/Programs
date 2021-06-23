package bd;
import java.sql.*;
/**
 *
 * @author Nicolas Garces, Marco Peña
 */
public class Conexion {
    public static Connection getConnection() {
        String url="jdbc:mysql://localhost:3306/consultamedica?zeroDateTimeBehavior=convertToNull";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
            return con;
            
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }
    
    
}
