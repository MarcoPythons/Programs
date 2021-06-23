/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Informática
 */
public class Automotora {

    private Moto[] bodega;
    private int indice = 0;

    public Automotora() {

        this.bodega = new Moto[100];
        this.indice = 0;

    }

    //agregar una moto a la bodega
    public void agregar(Moto moto) {
        if (indice > bodega.length) {
            System.out.println("Bodega llena");
        } else {
            this.bodega[this.indice] = moto;
            this.indice++;

        }
    }

//este metodo es para buscar una moto por la patente, solo que este metodo
    /* public Moto buscar(String patente) {

        for (Moto moto : this.bodega) {
            if (moto != null && moto.getPatente().equals(moto)) {
                return moto;
        
            }
    
        }
        return null ;
    }
    
    
     */
    // buscar una moto por la patente
    public Moto buscar(String patente) {

        for (int i = 0; i < this.indice; i++) {
            if (bodega[i] != null && bodega[i].getPatente().equals(patente)) {
                
                return bodega[i];
                

            }

        }
        return null;
    }

    //eliminar una moto por la patente
    public Moto eliminar(String patente) {

        for (int i = 0; i < this.indice; i++) {
            if (bodega[i] != null && bodega[i].getPatente().equals(patente)) {

                Moto motoEliminada = bodega[i];
                bodega[i] = null;

                return motoEliminada;

            }

        }
        return null;
    }

//para cambiar el precio a una moto
    public boolean actualizarMoto(String patente, int precio) {

        for (int i = 0; i < this.indice; i++) {
            if (bodega[i] != null && bodega[i].getPatente().equals(patente)) {
                bodega[i].setPrecio(precio);
                return true;

            }

        }
        return false;
    }

    public void reporte() {
        System.out.println("--NOMINA DE MOTOS--");
        System.out.println(" (" + new java.util.Date() + ")");
        System.out.println("---------------------------------------");
        for (int i = 0; i < this.indice; i++) {
            if (bodega[i] != null) {
                bodega[i].mostrarDatos();
            }
        }

        System.out.println("-------------------------------------------");

    }

}
