/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlodor;

import java.util.ArrayList;
import modelo.Producto;

/**
 *
 * @author Informática
 */
public interface IProducto {
    
    
    int create(Producto producto);
    int delete(int codigo); //investigar eliminar en cascada
    Producto search(int codigo);
    int modify(int codigo, String descripcion);
    ArrayList<Producto> productsList();
    
}
