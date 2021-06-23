
import java.util.ArrayList;

/**
 *
 * @author Marco Peña
 */
public class Empresa {

    private ArrayList<Empleado> empleados;

    public Empresa() {

        empleados = new ArrayList();
    }

    public Empleado agregarEmpleado(String rut) {
       
       for(Empleado emp: empleados)
        if (empleados.contains(emp)) {
            System.out.println("El empleado se encuentra registrado en la empresa");

        } else {
            empleados.add(emp);
            System.out.println("hols");

            

        }
        System.out.println("Chupalop");
        return null;
    }
    
    

}
