package Controlador;

import java.sql.*;
import java.util.ArrayList;
import modelo.Estudiante;

/**
 *
 * @author Marco Peña
 */
public class EstudianteADO implements IEstudiante{
    // url ---> jdbc:mysql://localhost:3306/automotora?zeroDateTimeBehavior=convertToNull
    // Driver class (api de java para que puede trabajar con mysql, este cambia dependiendo del motor de la BD)---> com.mysql.jdbc.Driver

    private Connection conn;
    private PreparedStatement pst;

    private ResultSet rs; // 

    public EstudianteADO() {
        String url = "jdbc:mysql://localhost:3306/escuela?zeroDateTimeBehavior=convertToNull";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Creacion exitosa");
        } catch (ClassNotFoundException error) {
            System.out.println(error.getMessage());
            System.out.println("Driver no registrado en la aplicación");

        } catch (SQLException sqlError) {
            System.out.println(sqlError.getMessage());
            System.out.println("Problemas con la connection fisica");
        }

    }

    public int crearVehiculo(Estudiante estudiante) {
        String sql = " insert into estudiante values(?,?,?);"; // el codigo sql siempre va con signos de interrogacion para que despues se remmplazen por el codigo de mas abajo
        try {
            this.pst = conn.prepareStatement(sql);
            this.pst.setString(1, estudiante.getRut());
            this.pst.setString(2, estudiante.getNombre());
            this.pst.setInt(3, estudiante.getEdad());
            //this.pst.executeQuery();  esta se usa para rescatar datos (select)
            int filas = this.pst.executeUpdate();// se usa para modificar una tabla ;
            pst.close();
            return filas;
        } catch (SQLException errorEX) {
            System.out.println("Problemas al registrar  un estudiante");
            System.out.println(errorEX.getMessage());
            return 0;

        }

    }

    public int eliminarVehiculo(Estudiante estudiante) {
        String sql = " DELETE FROM estudiante WHERE nombre= ?"; // el codigo sql siempre va con signos de interrogacion para que despues se remmplazen por el codigo de mas abajo
        try {
            this.pst = conn.prepareStatement(sql);
            this.pst.setString(1, estudiante.getNombre());
            // st = pst.executeQuery();  esta se usa para rescatar datos (select)

            int filas = this.pst.executeUpdate();// se usa para modificar una tabla ;
            pst.close();
            return filas;
        } catch (SQLException errorEX) {
            System.out.println("Problemas al eliminar  un estudiante");
            System.out.println(errorEX.getMessage());
            return 0;
        }

    }

    public int eliminarVehiculo(String rut) {
        String sql = " DELETE FROM estudiante WHERE rut= ?"; // el codigo sql siempre va con signos de interrogacion para que despues se remmplazen por el codigo de mas abajo
        try {
            this.pst = conn.prepareStatement(sql);
            this.pst.setString(1, rut);
            //this.pst.executeQuery();  esta se usa para rescatar datos (select)

            int filas = this.pst.executeUpdate();// se usa para modificar una tabla ;
            pst.close();
            return filas;
        } catch (SQLException errorEX) {
            System.out.println("Problemas al eliminar  un estudiante");
            System.out.println(errorEX.getMessage());
            return 0;

        }

    }

    public Estudiante buscarEstudiante(String rut) {
        String sql = "SELECT * FROM estudiante WHERE rut = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, rut);
            rs = pst.executeQuery(); // Esto guarda los campos en rs (ResultSet)
            if (rs.next()/**
                     * esto hace avanzar entre los campos para encontrar) *
                     */
                    ) {//con el if hacemos esta pregunta ¿ existe el registro? y si el registro existe hacemos lo siguiente del if
                String nombre = rs.getString("nombre"); // lo que esta dentro de los parentesis es el nombre del atributo de la tabla estudiane
                int edad = rs.getInt("Edad");

                return new Estudiante(rut, nombre, edad);

            }
            return null;

        } catch (SQLException errorEX) {
            System.out.println("Error al crear registrar un estudiante");
            System.out.println(errorEX.getMessage());
            return null;
        }

    }

    public ArrayList<Estudiante> listaEstudiante() {
        ArrayList<Estudiante> datos = new ArrayList<Estudiante>();
        String sql = "SELECT * FROM estudiante";
        String rut, nombre;  // variables auxiliares
        int edad;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // Esto guarda los campos en rs (ResultSet)
            while (rs.next()) { // asi recorremos todos los datos
                rut = rs.getString("rut");
                nombre = rs.getString("nombre");
                edad = rs.getInt("edad");
                datos.add(new Estudiante(rut, nombre, edad));

            }
            return datos;

        } catch (SQLException errorEX) {
            System.out.println("Error al mostrar los estudiante");
            System.out.println(errorEX.getMessage());
            return datos;
        }

    }

    public ArrayList<Estudiante> buscarPorNombre(String nombre) {
        ArrayList<Estudiante> datos = new ArrayList<Estudiante>();
        String sql = "SELECT * FROM estudiante WHERE nombre = ?";
        String rut;  // variables auxiliares
        int edad;

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nombre);// el numero es la posicion de las interrogantes que hay en la consulta
            rs = pst.executeQuery(); // Esto guarda los campos en rs (ResultSet)
            while (rs.next()) { // asi recorremos todos los datos
                rut = rs.getString("rut");
                nombre = rs.getString("nombre");
                edad = rs.getInt("edad");
                datos.add(new Estudiante(rut, nombre, edad));

            }
            return datos;

        } catch (SQLException errorEX) {
            System.out.println("Error al mostrar los estudiante");
            System.out.println(errorEX.getMessage());
            return datos;
        }

    }

    public int modificarNombre(String nombre, String rut) {

        String sql = "update estudiante set nombre = ? where rut = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, rut);

            int filas = this.pst.executeUpdate();// se usa para modificar una tabla ;
            pst.close();
            return filas;

        } catch (SQLException errorEX) {
            System.out.println("Error al mostrar los estudiante");
            System.out.println(errorEX.getMessage());
            return 0;
        }

    }

}
