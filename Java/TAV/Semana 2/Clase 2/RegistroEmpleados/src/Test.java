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
        
        Empresa e = new Empresa();
        Puesto puesto = new Puesto(13, "Jefe de finanzas");
        Puesto puesto1 = new Puesto(13, "Progamador");
        Empleado empleado = new Empleado("20.203.805-0", "Marco", "Peña", 'M', 7, 28, puesto);
        Empleado empleado1= new Empleado("20.205.216-8", "Marcelo", "Diaz", 'M', 2,23, puesto1);
        
        
        e.agregarEmpleado("20.203.805-0");
        e.agregarEmpleado("20.205.216-8");
        //empleado1.mostrarDatosEmpleado();
        
        
    }
    
}
