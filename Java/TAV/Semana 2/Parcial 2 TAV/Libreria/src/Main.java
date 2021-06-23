
/**
 * En esta clase testeamos los metodos implementados
 *
 * @author Marco Peña
 */
public class Main {

    public static void main(String[] args) {

        Infantil i = new Infantil(12, "El principito", 20, 15000);
        Tecnico t = new Tecnico(true, "Aprende java en 21 días", 501, 15000);
        RegistroLibro registro = new RegistroLibro();
        
        registro.agregarLibro(i);
        //registro.agregarLibro(i);
        registro.agregarLibro(t);
        System.out.println(i.obtenerTotalFinal(1));
        registro.librosExtensos();
        registro.eliminarLibro("El principito");
        
       

    }

}
