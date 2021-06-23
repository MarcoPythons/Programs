
/**
 * Clase que representa un Libro infantil
 * Esta clase hereda los atributos de la clase padre Libro que a la vez esta implenta la interfaz ICalculable
 *
 * @author Marco Peña
 */
public final class Infantil extends Libro {

    private int rangoEdad; // atributo que nos indica para que edad se esta comprando el libro, osea si pone 9, el libro se esta comprando para un niño de 9 años

    /**
     * Constructor sin parametros para la clase hija Infantil
     */
    public Infantil() {
    }

    /**
     * Constructor con parametros para la clase hija Infantil
     *
     * @param rangoEdad nos indica para que edad se esta comprando el libro,
     * osea si pone 9, el libro se esta comprando para un niño de 9 años
     * @param titulo representa el titulo del libro infantil
     * @param numeroPag representa el numero de paguinas del libro infantil
     * @param precio representa el precio del libro infantil
     */
    public Infantil(int rangoEdad, String titulo, int numeroPag, double precio) {
        super(titulo, numeroPag, precio);
        this.setRangoEdad(rangoEdad);
    }

    /**
     * Este método retorna la edad para la que se esta comprando este libro
     * infantil
     *
     * @return la edad del niño al que se le esta comprando el libro(el rango es
     * de 9 a 12 años)
     */
    public int getRangoEdad() {
        return rangoEdad;
    }

    /**
     * Este método permite modificar la edad del niño para la que se esta
     * comprando el libro(el rango es de 9 a 12 años)
     *
     * @param rangoEdad
     */
    public void setRangoEdad(int rangoEdad) {
        if (rangoEdad >= 9 && rangoEdad <= 12) {
            this.rangoEdad = rangoEdad;
        } else {
            System.out.println("El rango de edad es de 9 a 12 años");
            this.rangoEdad = -1;
        }
    }

    @Override
    /**
     * Método sobrecargado que si el rando de edad esta en el rango(valga la
     * rebundancia) el método nos retornara la informacion del libro
     */
    public void clasificacionLibro() {

        if (this.getRangoEdad() != -1) {
            System.out.println("INFANTIL: " + this.titulo + ", " + this.precio + " para menores entre 9 y 12 años");
        } else {
            System.out.println(this.getRangoEdad());
        }

    }

    /**
     * Metodo sobrecargado que a la cantidad retornada del método
     * obtenerTotalCompra le resta la multiplicacion de la cantidad retornada
     * del método obtenerTotalCompra contra DESCUENTO_LIBRO_INFANTIL
     *
     * @param cantidad representa la cantidad de libros a comprar
     * @return retorna el total de la compra despues aplicado el descuento exclusivo de los libros infantiles
     */
    @Override
    public double descuento(int cantidad) {
        double total;
        total = this.obtenerTotalCompra(cantidad) - (this.obtenerTotalCompra(cantidad) * DESCUENTO_LIBRO_INFANTIL);
        return total;
    }

}
