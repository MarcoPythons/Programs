
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
public class Test {
    public static void main(String[] args) {
        Alumno a = new Alumno(200000, 2019, "Ingenieria en informatica", "20.203.805-0", "Marco Peña");
        Profesor p = new Profesor("Programador", "HOLA", "18.325.355-k", "Julian prado");
        Auxiliar aux = new Auxiliar("Guardia", 200000, "19.564.255-5", "Jose Diaz");
        a.mostrarDatos();
        p.mostrarDatos();
        aux.mostrarDatos();
        
        ArrayList<Persona> listaPersona = new ArrayList<Persona>();
        
       // listaPersona.add(a);
       // listaPersona.add(p);
       // listaPersona.add(aux);
        
        for(Persona per : listaPersona)
            per.mostrarDatos();
        
    }
   
}
