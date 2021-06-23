/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Informática
 */
public class Bodega {

    private int codigo;
    private int cantidad;

    public Bodega() {
    }

    public Bodega(int codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Bodega{" + "codigo=" + codigo + ", cantidad=" + cantidad + '}';
    }
    
    

}
