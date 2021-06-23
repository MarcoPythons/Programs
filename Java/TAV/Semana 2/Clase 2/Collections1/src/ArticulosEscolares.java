
import java.util.ArrayList;

/**
 *
 * @author Marco Peña
 */
public class ArticulosEscolares {

    public static void main(String[] args) {
        ArrayList<String> articulos = new ArrayList<String>();   //asi iniciamos una arraylist de tipo String

        articulos.add("Cuaderno"); //para añadir articulos a la arraylist
        articulos.add("Lapiz");
        articulos.add("Regla");
        articulos.add("Estuche");
        articulos.add("Mochila");
        articulos.set(0, "Sacapuntas"); //para remplazar articulos
        articulos.remove("Regla"); //para eliminar el articulo describiendo el articulo
        articulos.remove(1); //para eliminar el articulo deciendo la posicion de este mismo

        //articulos.clear();//Limpia todo el arraylist
        System.out.println(articulos.indexOf("Estuche"));// indexof devuelve la posicion del objeto en el ArrayList
        System.out.println(articulos.indexOf("Corrector"));// si el articulo no existe este metodo lanzara un -1
        System.out.println(articulos.contains("Corrector"));// si el articulo no existe este metodo lanzara un false
        if (articulos.contains("Corrector")) {
            System.out.println(articulos.get(articulos.indexOf("Mochila")));
        } else {
            System.out.println("El articulo no existe");
        }
        for (int i = 0; i < articulos.size(); i++) {
            System.out.print(articulos.get(i) + " ");
        }
        System.out.println("");
        for (String i : articulos) {
            System.out.print(i + " ");
        }

    }

}
