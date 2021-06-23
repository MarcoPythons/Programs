/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlodor;

import java.util.ArrayList;
import modelo.Bodega;


/**
 *
 * @author Informática
 */
public interface IBodega {
    
    int create(Bodega producto);
    int delete(int codigo); //investigar eliminar en cascada
    Bodega search(int codigo);
    int modify(int codigo,int cantidad);
    ArrayList<Bodega> productsList();
    
}
