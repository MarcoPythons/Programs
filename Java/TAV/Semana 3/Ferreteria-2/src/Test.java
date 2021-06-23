
import controlodor.BodegaADO;
import controlodor.ProductoADO;
import java.sql.*;
import java.util.ArrayList;
import modelo.Producto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maily
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        ProductoADO p = new ProductoADO();
        BodegaADO b = new BodegaADO();
        //System.out.println(b.search(4));
        System.out.println(b.modify(4, 4));
//        ArrayList<Producto> producto = p.productsList();
//        for(Producto productos : producto)
//            System.out.println(productos);

    
    }
}
