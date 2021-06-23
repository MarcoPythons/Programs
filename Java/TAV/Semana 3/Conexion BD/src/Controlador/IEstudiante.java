/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import modelo.Estudiante;

/**
 *
 * @author Informática
 */
public interface IEstudiante {

    public int crearVehiculo(Estudiante estudiante);

    public int eliminarVehiculo(Estudiante estudiante);

    public int eliminarVehiculo(String rut);

    public Estudiante buscarEstudiante(String rut);

    public ArrayList<Estudiante> listaEstudiante();

    public ArrayList<Estudiante> buscarPorNombre(String nombre);

    public int modificarNombre(String nombre, String rut);

}
