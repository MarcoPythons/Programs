/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Informática
 */
public class Main {
    public static void main(String[] args) {
        Paciente a = new Paciente("marcelo", "perez", 20, true, 82.0, 1.67);
        
        
       
      
        
        a.calculoImc();
        a.estadoNutricional();
        a.mostrarDatos();
        
    }
}
