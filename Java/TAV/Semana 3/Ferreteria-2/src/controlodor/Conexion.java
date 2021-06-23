/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlodor;

import java.sql.*;

/**
 *
 * @author Informática
 */
public class Conexion {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/ferreteria?zeroDateTimeBehavior=convertToNull";
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Creacion exitosa");
            return conn;
        } catch (ClassNotFoundException error) {
            System.out.println(error.getMessage());
            System.out.println("Driver no registrado en la aplicación");
            return null;

        } catch (SQLException sqlError) {
            System.out.println(sqlError.getMessage());
            System.out.println("Problemas con la connection fisica");
            return null;
        }

    }
}
