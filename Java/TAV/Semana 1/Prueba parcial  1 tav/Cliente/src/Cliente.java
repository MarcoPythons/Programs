/*Esta clase es para guardar los datos del clientes
 * 
 * 
 * 
 */

/**
 *
 * @author Nicolas Garces
 * @author Marco Peña
 * @version (1.0)
 */
public class Cliente {

    private String rut;//Atributo que representa el rut del cliente
    private String nombreCompleto; //Atributo que representa el nombre completo del cliente
    private String correoElectronico; //Atributo que representa el correo electronico del cliente
    private String tipoCliente; // Atributo que representa el tipo de cliente "p" es preferencial y "n" es cliente normal

    /**
     * Constructor sin argumentos para la clase Cliente
     */
    public Cliente() {
    }

    /**
     * Constructor con argumentos para la clase Estacionamiento
     *
     * @param rut de tipo String que representa el rut del cliente
     *
     * @param nombreCompleto de tipo String que representa el nombre completo
     * del cliente
     *
     * @param correoElectronico de tipo String que representa el correo
     * electronico del cliente
     *
     * @param tipoCliente de tipo String que representa el tipo de cliente si es
     * normal o preferente
     *
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Cliente(String rut, String nombreCompleto, String correoElectronico, String tipoCliente) {
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.setTipoCliente(tipoCliente);
    }

    /**
     * Metodo que nos permite obtener los datos del rut del cliente
     *
     *
     * @return rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * metodo que nos permite modificar el rut del cliente
     *
     * @param rut representa el rut
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * Metodo que nos permite obtener el nombre completo del cliente
     *
     *
     * @return nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * metodo que nos permite modificar el nombre completo del cliente
     *
     * @param nombreCompleto representa el nombre completo del cliente
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Metodo que nos permite obtener el correo electronico del cliente
     *
     * @return correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * metodo que nos permite modificar el correo electronico del cliente
     *
     * @param correoElectronico representa el correo electronico del cliente
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * metodo que nos permite obtener el tipo de cliente
     *
     * @return tipoCliente
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * metodo que nos permite modificar el tipo cliente del cliente si es "N"
     * significa que es cliente normal y si es "P" significa que es cliente
     * preferencial
     *
     * @param tipoCliente representa el tipo de cliente
     */
    public void setTipoCliente(String tipoCliente) {
        if (tipoCliente.equals("N")) {
            this.tipoCliente = "cliente normal";
        }
        if (tipoCliente.equals("P")) {
            this.tipoCliente = "cliente preferencial";

        }
    }

    /* Metodo que nos permite mostrar los datos del cliente
    *
     */
    public void mostrarDatos() {
        System.out.println("Rut del cliente :" + rut);
        System.out.println("Nombre completo del cliente: " + nombreCompleto);
        System.out.println("Correo electronico del cliente: " + correoElectronico);
        System.out.println("Tipo Cliente: " + tipoCliente);

    }

}
