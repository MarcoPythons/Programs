/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlodor;

import java.sql.*;
import java.util.ArrayList;
import modelo.Producto;

/**
 *
 * @author Informática
 */
public class ProductoADO implements IProducto {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProductoADO() throws SQLException {
        conn = Conexion.getConnection();
    }

    @Override
    public int create(Producto producto) {
        String sql = "insert into producto values(?,?)";
        try {
            this.pst = conn.prepareStatement(sql);
            this.pst.setInt(1, producto.getCodigo());
            this.pst.setString(2, producto.getDescripcion());
            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;
        } catch (SQLException errorEX) {
            System.out.println("Error al registrar un producto");
            System.out.println(errorEX.getMessage());
            return 0;
        }

    }

    @Override
    public int delete(int codigo) {
        String sql = "delete from producto where codigo = ?";
        try {
            this.pst = conn.prepareStatement(sql);
            this.pst.setInt(1, codigo);
            int rowAffected = this.pst.executeUpdate();
            pst.close();
            return rowAffected;
        } catch (SQLException errorEX) {
            System.out.println("Error al eliminar un producto");
            System.out.println(errorEX.getMessage());
            return 0;
        }

    }

    @Override
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public Producto search(int codigo) {
        String sql = "select * from producto where codigo = ?";
        String descripcion;
        try {
            this.pst = conn.prepareStatement(sql);
            this.pst.setInt(1, codigo);
            rs = pst.executeQuery();
            if (rs.next()) {
                codigo = rs.getInt("codigo");
                descripcion = rs.getString("descripcion");
                return new Producto(codigo, descripcion);
            } else {
                return null;
            }
        } catch (SQLException errorEX) {
            System.out.println("El producto no existe");
            System.out.println(errorEX.getMessage());
            return null;
        }

    }

    @Override
    public int modify(int codigo, String descripcion) {
        String sql = "update producto set codigo = ? where descripcion = ?;";
        try {
            this.pst = conn.prepareStatement(sql);
            this.pst.setInt(1, codigo);
            this.pst.setString(2, descripcion);
            int rowAffected = this.pst.executeUpdate();
            pst.close();
            return rowAffected;
        } catch (SQLException errorEX) {
            System.out.println("Error al modificar un producto");
            errorEX.getMessage();
            return 0;
        }
    }

    @Override
    public ArrayList<Producto> productsList() {
        ArrayList<Producto> producto = new ArrayList();
        String sql = "select * from producto";
        int codigo;
        String descripcion;
        try {
            this.pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("codigo");
                descripcion = rs.getString("descripcion");
                producto.add(new Producto(codigo, descripcion));

            }
            return producto;
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

}


