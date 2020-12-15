
import controlador.AccesToBDUsers;
import java.util.Scanner;
import modelo.User;
import controlador.BDTableGastos;
import java.util.ArrayList;
import modelo.TipoPago;
import java.util.Date;

/**
 *
 * @author marco
 */
public class Test {
    public static void main(String[] args) {
        
        
        AccesToBDUsers bd = new AccesToBDUsers();
        String passwordI = "Jetblackheart1.";
        String cadenaEncriotada= bd.ecnode("Kakaroto", passwordI);
        String passwordD = bd.deecnode("Kakaroto", cadenaEncriotada);
        User user = new User(987654321, "Maily", passwordI);
        Scanner input = new Scanner(System.in);
        System.out.println(bd.addUser(user));
       //System.out.println(bd.searchByName("Maily"));
        //System.out.println(bd.deleteUser(user));
        String u = "Maily";
        String p = "Jetblackheart1.";
        System.out.println(passwordD);
        System.out.println(cadenaEncriotada);
          if(p.equals(passwordI))
              System.out.println(bd.Login(u, cadenaEncriotada));
          else
              System.out.println("Tu puta madre");
          
//        System.out.println("----------------------------------------------------------------------------");
//        
//        TipoPago pagos = new TipoPago();
//        BDTableGastos bn = new BDTableGastos();
//        
//        ArrayList<TipoPago> g = bn.searchAll();
//        
//        
//        for (TipoPago j : g)
//            System.out.println(j);
//        
//        int code = (int)(Math.random()*100000000+1);
//        
//        System.out.println(code);
        
        
        
        
        
        
    }
}
