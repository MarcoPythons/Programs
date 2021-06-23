/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import basedato.Basedato;
import java.util.ArrayList;
import modelo.Contacto;
import java.sql.*;

/**
 *
 * @author Informática
 */
public class ContactoADO implements IContacto {
    private final Connection con = Basedato.getConnection();

    @Override
    public int create(Contacto contacto) {
        String sql="insert into contacto values (?,?,?,?)";
        PreparedStatement pst;
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, contacto.getCorreo());
            pst.setString(2, contacto.getTelefono());
            pst.setString(3, contacto.getApellido());
            pst.setString(4, contacto.getNombre());
            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;
            
        } catch(SQLException error) {
            System.out.println(error.getMessage());
            return 0;
        } 
    }

    @Override
    public int delete(String correo) {
        String sql="delete from contacto where correo = ?";
        PreparedStatement pst;
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, correo);
            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;
            
        } catch(SQLException error) {
            System.out.println(error.getMessage());
            return 0;
        }     
    }

    @Override
    public int update(Contacto contacto) {
        String sql="update contacto set telefono=? where correo=?";
        PreparedStatement pst;
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, contacto.getTelefono());
            pst.setString(2, contacto.getCorreo());
            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;
            
        } catch(SQLException error) {
            System.out.println(error.getMessage());
            return 0;
        }    
    }

    @Override
    public Contacto findByEmail(String correo) {
        String sql="select * from contacto where correo=?";
        String telefono, nombre, apellido;
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, correo);
            rs = pst.executeQuery();
            if (rs.next()) {
                telefono=rs.getString("telefono");
                apellido=rs.getString("apellido");
                nombre=rs.getString("nombre");
                return new Contacto(correo, telefono, apellido, nombre);
            } else
                return null;
            
        } catch(SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Contacto> findAll() {
        String sql="select * from contacto";
        String correo, telefono, nombre, apellido;
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Contacto> contactos = new ArrayList();
        
        try {
            System.out.println(con);
            pst=con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                correo = rs.getString("correo");
                telefono=rs.getString("telefono");
                apellido=rs.getString("apellido");
                nombre=rs.getString("nombre");
                contactos.add(new Contacto(correo, telefono, apellido, nombre));
            } 
            return contactos;
            
        } catch(SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
        
    }
    
    
}
