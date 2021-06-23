

/**
 *
 * @author Maily
 */
public abstract class Producto /*implements ProductoDescontable*/ {

    protected int codigo;
    protected double precio;
    protected int stock;
    protected String tipo;
    protected String marca;

    public Producto() {
    }

    public Producto(int codigo, double precio, int stock, String tipo, String marca) {
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.tipo = tipo;
        this.marca = marca;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
            
        }else {
            System.out.println("No hay stock del producto solicitado");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
   // public abstract void imprimirInfo();

    
    public void imprimirInfo() {
        System.out.println("---------------------------------------------------");
        System.out.println( "Producto{" + "codigo= " + codigo + ", precio= " + precio + ", stock= " + stock + ", tipo= " + tipo + ", marca= " + marca + '}');
        System.out.println("---------------------------------------------------");
    }
    public abstract int calcularTotal(int cantidad);
}
