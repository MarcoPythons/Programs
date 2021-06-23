/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Informática
 */
public class Test {

    public static void main(String[] args) {
        Empresa e = new Empresa();
        Puesto puesto = new Puesto(1, "Programador");
        Puesto puesto1 = new Puesto(2, "Marketing");
        Empleado empleado = new Empleado("20.203.805-0", "Marco", "Peña", 'M', 7, 30, puesto);
        Empleado empleado2 = new Empleado("20.203.805-0", "Marco", "Peña", 'M', 7, 30, puesto);
        Empleado empleado1 = new Empleado("20.805.602-k", "Alejandra", "Perez", 'F', 5, 28, puesto1);
        
        
        e.agregarEmpleado(empleado);
        e.agregarEmpleado(empleado2);
        //empleado.mostrarDatos();
        //empleado1.mostrarDatos();
       
       //e.listarEmpleado("20.203.805-0");
        //e.listarEmpleado("20.805.602-k");
       

    }

}
