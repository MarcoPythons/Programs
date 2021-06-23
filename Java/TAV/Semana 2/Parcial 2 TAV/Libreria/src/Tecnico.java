
/**
 * Clase que representa un Libro Tecnico
 * Esta clase hereda los atributos de la clase padre Libro que a la vez esta implenta la interfaz ICalculable
 * @author Marco Peña
 */
public class Tecnico extends Libro {

    private boolean indicadorCDoDVD; // Atributo boolean que represinta si el libro trae cd o dvd 

    /**
     * Constructor sin parametros para tecnico(libro tecnico)
     */
    public Tecnico() {
    }

    /**
     * Constructor con parametros para la clase hija Tecnico
     *
     * @param indicadorCDoDVD represinta si el libro trae cd o dvd 
     * @param titulo representa el titulo del libro tecnico
     * @param numeroPag representa el numero de paguinas del libro tecnico
     * @param precio representa el precio del libro tecnico
     */
    public Tecnico(boolean indicadorCDoDVD, String titulo, int numeroPag, double precio) {
        super(titulo, numeroPag, precio);
        this.indicadorCDoDVD = indicadorCDoDVD;
    }

    /**
     * Este método permite saber si el libro trae cd(true) o dvd(false)
     * @return
     */
    public boolean isIndicadorCDoDVD() {
        return indicadorCDoDVD;
    }

    /**
     *  Este método nos permite modificar el atributo indicadorCDoDVD
     * @param indicadorCDoDVD
     */
    public void setIndicadorCDoDVD(boolean indicadorCDoDVD) {
        this.indicadorCDoDVD = indicadorCDoDVD;
    }

    @Override
    public void clasificacionLibro() {
        System.out.println("TÉCNICO: " + this.titulo + ", " + this.precio);
    }
    
    /**
     * Metodo sobrecargado que a la cantidad retornada del método
     * obtenerTotalCompra le resta la multiplicacion de la cantidad retornada
     * del método obtenerTotalCompra contra DESCUENTO_LIBRO_TECNICO
     *
     * @param cantidad representa la cantidad de libros a comprar
     * @return retorna el total de la compra despues aplicado el descuento exclusivo de los libros tecnico
     */
    @Override
    public double descuento(int cantidad) {
        double total;
        total = this.obtenerTotalCompra(cantidad) - (this.obtenerTotalCompra(cantidad) * DESCUENTO_LIBRO_TECNICO);
        return total;
    }
    /**
     * Este método indica si el libro tecnico lleva cd o dvd, si indicadorCDoDVD es true el libro trae cd y si el false trae dvd
     * @return los datos del libro
     */
    @Override
    public String toString() {
        if (this.indicadorCDoDVD) {
            return "Libro{" + "titulo: " + titulo + ", numero de paginas: " + numeroPag + ", precio: " + precio + ", libro incorpora CD" + '}';
        } else {
            return "Libro{" + "titulo: " + titulo + ", numero de paginas: " + numeroPag + ", precio: " + precio + ", libro incorpora DVD" + '}';
            
        }
    }
}
