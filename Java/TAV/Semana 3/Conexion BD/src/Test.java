/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Controlador.EstudianteADO;
import java.util.ArrayList;
import modelo.Estudiante;

/**
 *
 * @author Informática
 */
public class Test {

    public static void main(String[] args) {
        int rowAffected = 0; // iterador para imprimir cuantas lineas fueron affectadas
        EstudianteADO bd = new EstudianteADO();
        Estudiante e = new Estudiante("1-2", "Sr.Perez", 30);
        //ArrayList<Estudiante> estudiante = bd.buscarPorNombre("Sr.Peña");
       
        //for (Estudiante es : estudiante) {
          //  System.out.println(estudiante);
           // System.out.println("----------------------------------------------------------------------------------------------------------------- ");
        //}

        //rowAffected = bd.crearVehiculo(e);
        //bd.eliminarVehiculo(e);
        //System.out.println("Fueron afectadas: " + rowAffected + " filas");
        //System.out.println(bd.buscarEstudiante("1-9")) ;
        // System.out.println();
    }

}
