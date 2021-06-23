/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maily
 */
public class Test {
    public static void main(String[] args) {
        Alumno a = new Alumno("20.203.805-0", "Marco peña", 20);
        Profesor p = new Profesor("Jorege pinelo", "18.204.865-9", 28);
        
        a.mostrarDatos();
        p.mostrarDatos();
    }
    
}
