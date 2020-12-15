package controlador;

import java.sql.*;
import BD.ConexionBD;
import java.util.ArrayList;
import modelo.TipoPago;

/**
 *
 * @author marco
 */
public class BDTableGastos {

    private final Connection con = ConexionBD.getConnection();

    public int addGasto(int code, String fecha, String metodoPago, float gasto, String notas) {

        String sql = "insert into tipopago values(?,?,?,?,?);";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, code);
            pst.setString(2, fecha);
            pst.setString(3, metodoPago);
            pst.setFloat(4, gasto);
            pst.setString(5, notas);
            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;

        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return -1;
        }

    }

    public int modifyGasto(String fecha, String metodoPago, float gasto, String notas, int code) {
        String sql = "update tipopago set fecha = ? , metodo_pago = ? , gasto = ?, notas = ? where code = ?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, fecha);
            pst.setString(2, metodoPago);
            pst.setFloat(3, gasto);
            pst.setString(4, notas);
            pst.setInt(5, code);
            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;
        } catch (SQLException error) {

            System.out.println(error.getMessage());
            return -1;
        }

    }

    public TipoPago searchByDate(String fecha) {
        String sql = "select * from tipopago where fecha = ?";
        String metodoPago, notas;
        float gastos;
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, fecha);
            rs = pst.executeQuery();
            if (rs.next()) {
                fecha = rs.getString("fecha");
                metodoPago = rs.getString("metodo_pago");
                gastos = rs.getFloat("gasto");
                notas = rs.getString("notas");
                return new TipoPago(fecha, metodoPago, gastos, notas);
            }

        } catch (SQLException error) {
            System.out.println(error.getMessage());

        }

        return null;
    }
    
    public ArrayList<TipoPago> searchAll(){
        
        String sql = "select fecha, metodo_pago,gasto, notas from tipopago;";
        String fecha,metodoPago,notas;
        float gasto;
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<TipoPago> pagos = new ArrayList();
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                fecha = rs.getString("fecha");
                metodoPago = rs.getString("metodo_pago");
                gasto = rs.getFloat("gasto");
                notas = rs.getString("notas");
                
                pagos.add(new TipoPago(fecha, metodoPago, gasto, notas));
            }
            return  pagos;
        }catch(SQLException error){
            System.out.println(error.getMessage());
        }
        
        
        
        
        return null;
    }

}
