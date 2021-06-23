/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maily
 */
public class Profesor {
    
    private String nombreCompleto;
    private String rut;
    private int edad;

    public Profesor() {
    }

    public Profesor(String nombreCompleto, String rut, int edad) {
        this.nombreCompleto = nombreCompleto;
        this.rut = rut;
        this.edad = edad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void mostrarDatos(){
        System.out.println("--------------------------");
        System.out.println("          Profesor");
        System.out.println("--------------------------");
        System.out.println("Nombre Completo: " +nombreCompleto);
        System.out.println("Rut: " + rut);
        System.out.println("Edad: "+ edad);
    }
    
    
    
}
