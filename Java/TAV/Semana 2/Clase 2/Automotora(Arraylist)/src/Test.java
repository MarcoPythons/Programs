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
        Moto m= new Moto("JHAF92", "Chevrolet", "aveo", 7000000);
        Moto m1= new Moto("KSJ54", "Hyundai", "aveo", 3000000);
        Moto m2= new Moto("JHS456", "NISSAN", "aveo", 5000000);
        Moto m3= new Moto("JAHDK", "VOLVO", "aveo", 2200000);
        Automotora a = new Automotora();
        
        a.agregar(m);
        //a.agregar(m1);
        //a.agregar(m2);
        a.reporte();
        //a.actualizar(m3, "JHAF92");
        //a.reporte();
    }
    
}
