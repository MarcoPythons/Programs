
/**
 *
 * @author Maily
 */
public class Pintura extends Producto implements ProductoDescontable {

    private int litros;

    public Pintura() {
    }

    public Pintura(int litros, int codigo, double precio, int stock, String tipo, String marca) {
        super(codigo, precio, stock, tipo, marca);
        this.litros = litros;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public void setTipo(String tipo) {
        if (this.tipo.equals("Pintura al temple") || this.tipo.equals("Pintura a la cal") || this.tipo.equals("Pintura al cemento") || this.tipo.equals("Pintura al silicato") || this.tipo.equals("Pintura al aceite") || this.tipo.equals("Esmalte sintético") || this.tipo.equals("Pintura bituminosa") || this.tipo.equals("Esmalte graso") || this.tipo.equals("Pintura al cloro-caucho") || this.tipo.equals("Barnices")) {
            this.tipo = tipo;
        }
    }

    public void setPrecio(double precio) {
        double precioFinal = precio * litros;
        this.precio = precioFinal;
    }

    @Override
    public double calcularDescuento(String dia) {
        double precioFinal;

        if (dia.equals("Lunes")) {

            precioFinal = this.precio - (this.precio * 0.08);
            return precioFinal;

        } else {
            return (int) -1;
        }

    }

    @Override
    public void imprimirInfo() {
        System.out.println("---------------------------------------------------");
        System.out.println("Producto{" + "codigo= " + codigo + ", precio= " + precio + ", stock= " + stock + ", tipo= " + tipo + ", marca= " + marca + ", listros= " + litros + '}');
        System.out.println("---------------------------------------------------");
    }

    @Override
    public int calcularTotal(int cantidad) {
        double precioFinal;
       
        if (this.getStock() > cantidad) {
            precioFinal = (int) this.precio * cantidad;
            this.stock = this.stock - cantidad;
            return (int) precioFinal;
        } else {
            System.out.println("No hay suficiente stock");
            return -1;
        }
    }

}
