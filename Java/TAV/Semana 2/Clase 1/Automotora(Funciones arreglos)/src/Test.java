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
        Automotora a = new Automotora();
        Moto m1 = new Moto("DYDJ66", "Hyundai", "AVEO", 7990000);
        Moto m2 = new Moto("GHSD12", "Chevrolet", "PRISMA", 1500000);
        Moto m3 = new Moto("JHSY76", "Zuzuki", "ALTO", 1000000);
        Moto m4 = new Moto("CHIC78", "Volvo", "SANCHES", 3000000);
        Moto m5 = new Moto("FGSF89", "Subaru", "IMPRESA", 4000000);
        
       
        
        a.agregar(m1);
        a.agregar(m2);
        a.agregar(m3);
        a.agregar(m4);
        a.agregar(m5);
        
      
        
        a.eliminar("DYDJ66");
        
        //a.reporte();
        a.buscar("GHSD12");
        
    }
    
}
