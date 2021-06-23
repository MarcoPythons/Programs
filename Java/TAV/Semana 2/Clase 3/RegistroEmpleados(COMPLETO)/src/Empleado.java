
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Informática
 */
public class Empleado {

    private String rut;
    private String nombre;
    private String apellido;
    private char genero;
    private int aniosServicio;
    private int edad;
    private Puesto puesto;

    public Empleado() {
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Empleado(String rut, String nombre, String apellido, char genero, int aniosServicio, int edad, Puesto puesto) {
        this.rut = rut;
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setGenero(genero);
        this.aniosServicio = aniosServicio;
        this.setEdad(edad);
        this.puesto = puesto;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio");
        } else {
            this.nombre = nombre;
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido.isEmpty()) {
            System.out.println("El apellido no puede estar vacio");
        } else {
            this.apellido = apellido;
        }
    }

    public char isGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        if (genero == 'M') {
            this.genero = genero;
        }
        if (genero == 'F') {
            this.genero = genero;
        }
    }

    public int getAniosServicio() {
        return aniosServicio;
    }

    public void setAniosServicio(int aniosServicio) {
        this.aniosServicio = aniosServicio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 18) {
            this.edad = edad;
        } else {
            System.out.println("La edad minima son 18 años");
        }
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public void mostrarDatosEmpleado() {
        System.out.println("-------------------------");
        System.out.println("      EMPLEADO");
        System.out.println("Rut: " + this.rut);
        System.out.println("Nombre completo: " + this.nombre + " " + this.apellido);
        System.out.println("Edad : " + this.edad);
        if (this.genero == 'M') {
            System.out.println("Genero: Masculino");
        }
        if (this.genero == 'F') {
            System.out.println("Genero : Femenino");
        }
        System.out.println("Años de servicio " + this.aniosServicio);
        System.out.println("Puesto :" + puesto.getNombrePuesto());
    }

    public void mostrarDatos() {
        System.out.println("-----------------------------");
        System.out.println("          EMPLEADO");
        System.out.println("Rut: " + this.rut);
        System.out.println("Nombre completo: " + this.nombre + " " + this.apellido);
        System.out.println("Años de servicio " + this.aniosServicio);
        System.out.println("Puesto :" + this.puesto.getNombrePuesto());
    }

 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.rut, other.rut)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return true;
    }
    

}
