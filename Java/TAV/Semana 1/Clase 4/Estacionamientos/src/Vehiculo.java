
import java.util.Objects; // se importa el paquete java.util.objects para poder aplicar el metodo equals

/*
 * Esta clase sirve para representar un Vehiculo para poder cobrar el estacionamiento
 * 
 * 

/**
 *
 * @author Marco peña
 */
public class Vehiculo {

    private String patente; //Atributo que representa la patente de un Vehiculo
    private String marca;// Atributo que representa la marca de un Vehiculo
    private String modelo; // Atributo que represnta el modelo de un Vehiculo
    private String tipo; // Atributo que representa el tipo de Vehiculo, este puede ser clasificado en : camioneta, moto o automovil

    /**
     * Constructor sin argumentos para la clase Vehiculo
     */
    public Vehiculo() {
    }

    /**
     * Constructor con argumentos para la clase Vehiculo
     *
     * @param patente de tipo String que representa la patente del Vehiculo
     * @param marca de tipo String que representa la marca del Vehiculo
     * @param modelo de tipo String que representa el modelo del Vehiculo
     * @param tipo de tipo String que representa el tipo del Vehiculo, este
     * puede ser: camioneta, moto o automovil
     */
    public Vehiculo(String patente, String marca, String modelo, String tipo) {
        this.setPatente(patente);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setTipo(tipo);
    }

    /**
     * Metodo que nos permite obtener la patente del Vehiculo
     *
     * @return patente
     */
    public String getPatente() {
        return patente;
    }

    /**
     *  Este metodo permite modificar la patente del Vehiculo.
     * La patente no puede ser null
     * @param patente
     */
    public void setPatente(String patente) {
        if (patente != null) {
            this.patente = patente;
        }
    }

    /**
     * Metodo que nos permite obtener la marca del Vehiculo
     *
     * @return marca
     */
    public String getMarca() {
        return marca;
    }
    /**
     * Metodo que permite modificar la marca del Vehiculo
     * La marca no puede ser null
     * @param marca 
     */
    public void setMarca(String marca) {
        if (marca != null) {
            this.marca = marca;
        }
    }

    /**
     * Metodo que nos permite obtener la modelo del Vehiculo
     *
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * Este metodo nos permite modificar el modelo del Vehiculo
     * El modelo no puede ser null
     * @param modelo 
     */
    public void setModelo(String modelo) {
        if (modelo != null) {
            this.modelo = modelo;
        }
    }

    /**
     * Metodo que nos permite obtener la tipo del Vehiculo
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Este metodo nos permite modificar el tipo del Vehiculo
     * el tipo solo puede ser: camioneta, moto o automovil
     * @param tipo 
     */
    public void setTipo(String tipo) {
        if (tipo == "camioneta" || tipo == "moto" || tipo == "automovil") {
            this.tipo = tipo;
        }
    }
    /**
     * Este metodo nos permite verificar si el Vehiculo es el mismo Vehiculo y si este cumple, nos retorna un true
     * @param obj
     * @return true
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.patente, other.patente)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }
    public void mostrarDatos(){
        System.out.println("La patente del vehiculo es: "+ this.patente);
        System.out.println("La marca del vehiculo es: "+ this.marca);
        System.out.println("El modelo del vehiculo es: "+this.modelo);
        System.out.println("El tipo de vehiculo es: "+ this.tipo);
    }
}
