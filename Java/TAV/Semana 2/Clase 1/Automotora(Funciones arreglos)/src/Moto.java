
/**
 *
 * @author Marco peña
 */
public class Moto {

    private String patente;
    private String marca;
    private String modelo;
    private int precio;
    

    public Moto() {
    }

    public Moto(String patente, String marca, String modelo, int precio) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
    public void mostrarDatos() {
        
        
        System.out.println("-----------------------------------");
        System.out.println("   MOTO ");
        System.out.println("-----------------------------");
        System.out.println("Patente: " + patente);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Precio: " + precio);
        System.out.println("------------------------------");
    }

}
