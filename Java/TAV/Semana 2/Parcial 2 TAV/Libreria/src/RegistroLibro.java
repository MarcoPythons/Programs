
import java.util.ArrayList;// se importa java util para poder usar ArrayLists

/**
 * Esta clase sirve para guardar libros en un estanteria de libros
 *
 * @author Marco Peña
 */
public class RegistroLibro {

    private ArrayList<Libro> estanteria; // Se declara una ArrayList de tipo Libro para poder almacenar libros en su interior

    /**
     * Constructor para poder instanciar el ArrayList
     */
    public RegistroLibro() {
        estanteria = new ArrayList<Libro>();
    }

    /**
     * Este método sirve para agregar un libro a la estanteria, primero le
     * pasamos el libro y si el libro se encuentra no lo agregará
     *
     * @param libro representa un libro
     */
    public void agregarLibro(Libro libro) {
        if (estanteria.contains(libro)) {
            System.out.println("El libro ingresado ya se encuentra registrado.");
        } else {
            estanteria.add(libro);
            System.out.println("El libro ha sido agregado correctamente.");
        }

    }

    /**
     * Este método sirve para poder mostrar los libros que se encuentran el
     * estanteria
     */
    public void listaLibros() {
        for (Libro libros : estanteria) {
            System.out.println(libros.toString());
        }
    }

    /**
     * Este método sirve para eliminar un libro de la estanteria. primero se le
     * pasa por parametro el titulo del libro, este recorerá la estanteria y si
     * el titulo es igual a algun titulo en la estanteria, el método eliminará
     * el libro de esta misma
     *
     * @param titulo representa el titulo de algún libro
     */
    public void eliminarLibro(String titulo) {
        for (Libro libro : estanteria) {
            if (libro.getTitulo().equals(titulo)) {
                estanteria.remove(libro);
                System.out.println("El libro ha sido eliminado de la estanteria correctamente.");
            } else {
                System.out.println("El libro no se encuentra en la estanteria.");
            }

        }

    }

    /**
     * Este método sirve para mostrar los libros que tengan más de 500 paguinas
     * Primero se recorre la estanteria y si el numero de paguinas de algun
     * libro es mayor que 500 paguinas el método mostrar toda la información del
     * libro
     */
    public void librosExtensos() {
        for (Libro libro : estanteria) {
            if (libro.getNumeroPag() > 500) {
                System.out.println(libro.toString());
            }
        }
    }

}
