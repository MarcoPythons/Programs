
/**
 *
 * @author Maily
 */
public class Martillo extends Producto implements ProductoDescontable{

    public Martillo() {
    }

    public Martillo(int codigo, double precio, int stock, String tipo, String marca) {
        super(codigo, precio, stock, tipo, marca);
    }

    public void setTipo(String tipo) {
        if (this.tipo.equals("Martillo común de carpintero") || this.tipo.equals("Martillo de bola") || this.tipo.equals("Martillo de geólogo") || this.tipo.equals("Martillo de ebanista") || this.tipo.equals("Martillo de tapicero")) {
            this.tipo = tipo;
        }
    }

    public void setPrecio(double precio) {
        if (this.precio >= 2000) {
            this.precio = precio;
        }
    }

    @Override
    public double calcularDescuento(String dia) {
        double precioFinal;

        if (dia.equals("Viernes")) {

            precioFinal = this.getPrecio() - (this.getPrecio() * 0.08);
            return precioFinal;

        } else {
            return (int)-1;
        }

    }
    @Override
     public void imprimirInfo() {
        System.out.println("---------------------------------------------------");
        System.out.println( "Producto{" + "codigo= " + codigo + ", precio= " + precio + ", stock= " + stock + ", tipo= " + tipo + ", marca= " + marca + '}');
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
