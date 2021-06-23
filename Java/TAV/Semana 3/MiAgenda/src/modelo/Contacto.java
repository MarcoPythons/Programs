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
public class Contacto {
    private String correo;
    private String telefono;
    private String apellido;
    private String nombre;

    public Contacto(String correo, String telefono, String apellido, String nombre) {
        this.correo = correo;
        this.telefono = telefono;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Contacto() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Contacto{" + "correo=" + correo + ", telefono=" + telefono + ", apellido=" + apellido + ", nombre=" + nombre + "}\n";
    }
    
}
