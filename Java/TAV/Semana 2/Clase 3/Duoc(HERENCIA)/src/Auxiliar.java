/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maily
 */
public class Auxiliar extends Persona {
   
   
    private String cargo;
    private int sueldo;

    public Auxiliar() {
    }

    public Auxiliar(String cargo, int sueldo, String rut, String nombreCompleto) {
        super(rut, nombreCompleto);
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    @Override
    public void mostrarDatos() {
      
        System.out.println("Datos del auxiliar");
        System.out.println("-------------------------");
        System.out.println("Nombre Completo: "+ this.nombreCompleto);
        System.out.println("Rut: "+ this.rut);
        System.out.println("Cargo: " + this.cargo);
        System.out.println("Sueldo: " + this.sueldo);
        System.out.println("-------------------------");

    }
    
    
    
}
