/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Informática
 */
public class Alumno extends Persona {

    private int matricula;
    private int anioIngreso;
    private String carrera;

    public Alumno() {
    }

    public Alumno(int matricula, int anioIngreso, String carrera, String rut, String nombreCompleto) {
        super(rut, nombreCompleto);
        this.matricula = matricula;
        this.anioIngreso = anioIngreso;
        this.carrera = carrera;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    @Override
    public void mostrarDatos() {
      
        System.out.println("Datos del alumno");
        System.out.println("-------------------------");
        System.out.println("Nombre Compleat: "+ this.nombreCompleto);
        System.out.println("Rut: "+ this.rut);
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Ingreso: " + this.anioIngreso);
        System.out.println("Carrera: " + this.carrera);
        System.out.println("-------------------------");

    }

}
