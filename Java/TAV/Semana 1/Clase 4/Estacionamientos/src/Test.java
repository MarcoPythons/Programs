
import java.util.Calendar;
import java.util.Date;

/*
 *
 * 
 * 
 */

/**
 *
 * @author Maily
 */
public class Test {
    public static void main(String[] args) {
        Vehiculo v = new Vehiculo("CSGH125", "chevrolet", "Cian", "automovil");
        Estacionamientos e = new Estacionamientos(v, new Date () , new Date (), new Date ());
        
        
        e.voucher();
        
        
      
    }
    
    
}
