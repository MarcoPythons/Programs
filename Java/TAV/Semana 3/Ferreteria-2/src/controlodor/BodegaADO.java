/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlodor;

import java.sql.*;
import java.util.ArrayList;
import modelo.Bodega;

/**
 *
 * @author Maily
 */
public class BodegaADO implements IBodega {
     private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    public BodegaADO() throws SQLException {
        conn = Conexion.getConnection();
    }

    @Override
    public int create(Bodega producto) {
        String sql = "insert into bodega values(?,?)";
        try {
            this.pst = conn.prepareStatement(sql);
            this.pst.setInt(1, producto.getCodigo());
            this.pst.setInt(2, producto.getCantidad());
            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;
        } catch (SQLException errorEX) {
            System.out.println("Error al registrar un producto en la bodega");
            System.out.println(errorEX.getMessage());
            return 0;
        }

    }

    @Override
    public int delete(int codigo) {
        String sql = "delete from bodega where codigo = ?";
        try {
            this.pst = conn.prepareStatement(sql);
            this.pst.setInt(1, codigo);
            int rowAffected = this.pst.executeUpdate();
            pst.close();
            return rowAffected;
        } catch (SQLException errorEX) {
            System.out.println("Error al eliminar un producto de la bodega");
            System.out.println(errorEX.getMessage());
            return 0;
        }

    }

    @Override
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public Bodega search(int codigo) {
        String sql = "select * from bodega where codigo = ?";
        int cantidad;
        try {
            this.pst = conn.prepareStatement(sql);
            this.pst.setInt(1, codigo);
            rs = pst.executeQuery();
            if (rs.next()) {
                codigo = rs.getInt("codigo");
                cantidad = rs.getInt("cantidad");
                return new Bodega(codigo, cantidad);
            } else {
                return null;
            }
        } catch (SQLException errorEX) {
            System.out.println("El producto no existe en la bodega");
            System.out.println(errorEX.getMessage());
            return null;
        }

    }

    @Override
    public int modify(int codigo,int cantidad) {
        String sql = "update bodega set cantidad = ? where codigo = ?;";
        try {
            this.pst = conn.prepareStatement(sql);
            this.pst.setInt(1, codigo);
            this.pst.setInt(2, cantidad);
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
    public ArrayList<Bodega> productsList() {
        ArrayList<Bodega> productos = new ArrayList();
        String sql = "select * from bodega;";
        int codigo;
        int cantidad;
        try {
            this.pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("codigo");
                cantidad = rs.getInt("descripcion");
                productos.add(new Bodega(codigo, cantidad));

            }
            return productos;
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }
    
}
