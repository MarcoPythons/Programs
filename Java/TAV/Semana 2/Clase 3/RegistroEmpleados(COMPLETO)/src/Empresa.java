
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Informática
 */
public class Empresa {

    private ArrayList<Empleado> nomina;

    public Empresa() {

        nomina = new ArrayList();
    }

    public void agregarEmpleado(Empleado empleado) {

        if (nomina.contains(empleado)) {
            System.out.println("El empleado ya se encuentra en la nomina");
        } else {
            nomina.add(empleado);
            System.out.println("El empleado a sido agregado correctamente");
        }

    }

    public void eliminarEmpleado(String rut) {
        for (Empleado empleado : nomina) {
            if (empleado.getRut().equals(rut)) {

                nomina.remove(rut);
                System.out.println("Empleado eliminado correctamente");
            } else {
                System.out.println(" El empleado no se encuentra en la nomina");
            }

        }

    }

    public void listarEmpleado(String rut) {
        for (Empleado empleado : nomina) {
            if (empleado.getRut().equals(rut)) {
                System.out.println("------------------------------------");

                System.out.println("       LISTA EMPLEADOS");
                System.out.println("------------------------------------");
                empleado.mostrarDatosEmpleado();

                System.out.println("------------------------------------");

            }
        }
    }
}
