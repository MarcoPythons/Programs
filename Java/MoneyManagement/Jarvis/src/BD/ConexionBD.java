
package BD;
import java.sql.*;
/**
 *
 * @author Maily
 */
public class ConexionBD {
    
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/jarvis";
        Connection cJavirs ;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cJavirs = DriverManager.getConnection(url, "root", "");
            return cJavirs;
            
            
        }catch(ClassNotFoundException | SQLException error){
            System.out.println("Error al conectar con la base de datos.");
            System.out.println("Informacion detallada: " + error.getMessage());
            
            return null;
            
        }
    
    } 

}

    
