
import java.util.ArrayList;

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

    private ArrayList<Moto> bodega;

    public Automotora() {
        bodega = new ArrayList<Moto>();

    }

    public boolean agregar(Moto moto) {

        if (bodega.contains(moto)) {
            return false;
        } else {
            bodega.add(moto);
        }
        return true;
    }

    public Moto buscar(Moto moto) {
        if (bodega.contains(moto)) {
            return bodega.get(bodega.indexOf(moto));
        } else {
            System.out.println("La moto no se encuentra ingesada");
            return null;
        }

    }

    public Moto buscar(String patente) {
        for (Moto moto : bodega) {
            if (moto.getPatente().equals(patente)) {
                return moto;
            }
        }
        System.out.println("La moto no se encuentra ingesada");
        return null;
    }

    public boolean eliminar(Moto moto) {

        if (bodega.contains(moto)) {
            bodega.remove(moto);
            return true;
        }

        return false;
    }

    public boolean eliminar(String patente) {
        for (Moto moto : bodega) {
            if (moto.getPatente().equals(patente)) {
                bodega.remove(moto);
                return true;

            }

        }
        return false;
    }

    public boolean actualizar(Moto moto) {
        Moto m = this.buscar(moto.getPatente());
        if (bodega.contains(m)) {
            bodega.set(bodega.indexOf(m), moto);
            return true;
        }
        System.out.println("La moto no se encuentra ingesada");
        return false;

    }

    public boolean actualizar(String patente, int precio) {

        Moto m = this.buscar(patente);
        Moto aux = m;
        if (bodega.contains(m)) {
            aux.setPrecio(precio);
            bodega.set(bodega.indexOf(m), aux);
            return true;
        }
        System.out.println("La moto no se encuentra ingesada");
        return false;

    }

    public boolean actualizar(Moto moto, String patente) {
        return false;

    }

    public void reporte() {
        System.out.println("REPORTE DE BODEGA DE MOTOS");
        System.out.println("-----------------------------");
        System.out.println(new java.util.Date());
        for (Moto moto : bodega) {
            moto.mostrarDatos();
            System.out.println("");
        }

        System.out.println("---------------------------------");
    }
}
