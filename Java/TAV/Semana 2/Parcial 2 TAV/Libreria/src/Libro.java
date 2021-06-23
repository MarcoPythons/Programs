
/**
 * Esta clase representa un libro con su titulo, numero de paguinas y tiene un precio
 * Esta es una clase padre, no se puede instanciar
 * Esta clase implementa la interfaz ICalculable.
 *
 * @author Marco Peña
 */
public abstract class Libro implements ICalculable {

    /**
     * Este atributo representa el titulo de un libro
     */
    protected String titulo;

    /**
     * Este atributo representa el numero de paguinas de un libro
     */
    protected int numeroPag;

    /**
     * Este atributo representa el precio de un libro
     */
    protected double precio;

    /**
     * Constructor por defecto de un libro
     */
    public Libro() {
    }

    /**
     * Constructor con parametros para un libro
     *
     * @param titulo representa el titulo de un libro
     * @param numeroPag representa la cantidad de paguinas de un libro
     * @param precio representa el precio de un libro
     */
    public Libro(String titulo, int numeroPag, double precio) {
        this.titulo = titulo;
        this.numeroPag = numeroPag;
        this.precio = precio;
    }

    /**
     * Método que retorna el titulo de un libro
     *
     * @return titulo de un libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método que permite modificar el titulo de un libro
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método que retorna la cantidad de paguinas de un libro
     *
     * @return numero de paguinas
     */
    public int getNumeroPag() {
        return numeroPag;
    }

    /**
     * Método que permite modificar el numero de de paguinas de un libro
     *
     * @param numeroPag
     */
    public void setNumeroPag(int numeroPag) {
        this.numeroPag = numeroPag;
    }

    /**
     * Método que retorna el precio de un libro
     *
     * @return precio de un libro
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Método que permite modificar el precio de un libro
     *
     * @param precio de un libro
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public double obtenerTotalCompra(int cantidad) {
        return this.precio * cantidad;
    }

    @Override
    public double obtenerTotalFinal(int cantidad) {
        double total;
        total = (this.descuento(cantidad) * (1 + IVA));
        return (int) total;
    }

    /**
     * Método abstracto para poder obtener la clasificacion de un libro, sea
     * para niños o para adultos
     */
    public abstract void clasificacionLibro();

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", numeroPag=" + numeroPag + ", precio=" + precio + '}';
    }

}
