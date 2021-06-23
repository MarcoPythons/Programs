/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedato;

import java.sql.*;

/**
 *
 * @author Informática
 */
public class Basedato {
    public static Connection getConnection() {
        String url="jdbc:mysql://localhost:3306/agenda?zeroDateTimeBehavior=convertToNull";
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
