
package controlador;

import bd.Conexion;
import java.sql.*;
import java.util.ArrayList;
import modelo.Paciente;

/**
 *
 * @author @author Nicolas Garces, Marco Peña
 */
public class Registro {

    private final Connection con = Conexion.getConnection();


    public int agrega(Paciente paciente) {
        String sql = "insert into pacientes values (?,?,?,?,?,?,?,?0);";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, paciente.getRut());
            pst.setString(2, paciente.getNombreCompleto());
            pst.setString(3, paciente.getGenero());
            pst.setInt(4, paciente.getEdad());
            pst.setString(5, paciente.getDireccion());
            pst.setString(6, paciente.getCiudad());
            pst.setString(7, paciente.getIsapre());
            pst.setBoolean(8, paciente.isDonante());
            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;

        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return 0;
        }
    }

    public int elimina(Paciente paciente) {
        String sql = "delete from pacientes where rut = ?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, paciente.getRut());
            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;

        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return 0;
        }
    }

    public int modificar(Paciente paciente) {
        String sql = "update pacientes set nombre =?, genero = ?, edad = ?, direccion = ?, ciudad = ?, isapre = ?, donante = ?  where rut=?;";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, paciente.getNombreCompleto());
            pst.setString(2, paciente.getGenero());
            pst.setInt(3, paciente.getEdad());
            pst.setString(4, paciente.getDireccion());
            pst.setString(5, paciente.getCiudad());
            pst.setString(6, paciente.getIsapre());
            pst.setBoolean(7, paciente.isDonante());
            pst.setString(8, paciente.getRut());
            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;

        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return 0;
        }
    }

    public Paciente buscarPorRut(String rut) {
        String sql = "select * from pacientes where rut=?";
        String nombreCompleto, genero, direccion, ciudad, isapre;
        int edad;
        boolean donante;
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, rut);
            rs = pst.executeQuery();
            if (rs.next()) {
                nombreCompleto = rs.getString("nombre");
                genero = rs.getString("genero");
                edad = rs.getInt("edad");
                direccion = rs.getString("direccion");
                ciudad = rs.getString("ciudad");
                isapre = rs.getString("isapre");
                donante = rs.getBoolean("donante");
                return new Paciente(rut, nombreCompleto, genero, edad, direccion, ciudad, isapre, donante);
            } else {
                return null;
            }

        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    public ArrayList<Paciente> buscarTodos() {
        String sql = "select * from pacientes";
        String rut, nombreCompleto, genero, direccion, ciudad, isapre;
        int edad;
        boolean donante;
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Paciente> pacientes = new ArrayList();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                rut=rs.getString("rut");
                nombreCompleto = rs.getString("nombre");
                genero = rs.getString("genero");
                edad = rs.getInt("edad");
                direccion = rs.getString("direccion");
                ciudad = rs.getString("ciudad");
                isapre = rs.getString("isapre");
                donante = rs.getBoolean("donante");
                pacientes.add(new Paciente(rut, nombreCompleto, genero, edad, direccion, ciudad, isapre, donante));
            }
            return pacientes;

        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }

    }

}
