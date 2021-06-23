
/**
 * Esta interface es para implementar métodos en la librería
 * Estos métodos afectarén a todas las clases de Libro
 *
 *
 * @author Marco Peña
 */
public interface ICalculable {

    /**
     * Esta constante es el IVA de cada libro que se aplicará en la venta
     */
    public static final float IVA = 0.19f;

    /**
     * Esta constante es un descuento para los libros infantiles, esta constante
     * se aplicará a la clase hija Infantil
     */
    public static final float DESCUENTO_LIBRO_INFANTIL = 0.10f;

    /**
     * Esta constante es un descuento para los libros tecnicos, esta constante
     * se aplicará a la clase hija Tecnico
     */
    public static final float DESCUENTO_LIBRO_TECNICO = 0.05f;

    /**
     * Este método calculara el precio por la cantidad del libro y retornara la
     * el precio por la cantidad de libros comprados
     *
     * @param cantidad representa la cantidad de libros a comprar
     * @return el precio por la cantidad de libros comprados
     */
    public double obtenerTotalCompra(int cantidad);

    /**
     * Este método calculara el descuento por el tipo de libro y retornara la el
     * precio descontado por la cantidad de libros comprados
     *
     * @param cantidad representa la cantidad de libros a comprar
     * @return el precio descontado del libro
     */
    public double descuento(int cantidad);

    /**
     * Este método calculara el descuento del tipo de libro y tambien calcula el
     * iva sobre este descuento y nos retorna el precio final de un x cantidad
     * de libros
     *
     * @param cantidad representa la cantidad de libros a comprar
     * @return el precio final del libro
     */
    public double obtenerTotalFinal(int cantidad);
}
