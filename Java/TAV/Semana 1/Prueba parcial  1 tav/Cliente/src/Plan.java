/*Esta clase es para guardar los datos del plan
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
public class Plan {

    private int numeroEquipo; //Atributo que representa el numero del equipo 
    private int cuotaNavegacion;  //Atributo que representa la cuota de navegacion del plan
    private int minutosIncluidos; //Atributo que representa los minutos incluidos en el plan
    private int cargoFijoPlan; //Atributo que representa el cargo fijo mensual del plan 
    private Cliente cliente;  //Atributo que representa al cliente

    /**
     * Constructor sin argumentos para la clase Plan
     */
    public Plan() {
    }

    /**
     * Constructor con argumentos para la clase Estacionamiento
     *
     * @param numeroEquipo de tipo int que representa el numero del plan
     *
     * @param cuotaNavegacion de tipo int que representa la cuota de navegacion
     * del plan
     *
     * @param minutosIncluidos de tipo int que representa los minutos incluidos
     * en el plan
     *
     * @param cargoFijoPlan de tipo int que representa el cargo fijo del plan
     *
     * @param cliente de tipo cliente que representa el cliente
     *
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Plan(int numeroEquipo, int cuotaNavegacion, int minutosIncluidos, int cargoFijoPlan, Cliente cliente) {
        this.setNumeroEquipo(numeroEquipo);
        this.cuotaNavegacion = cuotaNavegacion;
        this.minutosIncluidos = minutosIncluidos;
        this.cargoFijoPlan = cargoFijoPlan;
        this.cliente = cliente;
    }

    /**
     * Metodo que nos permite obtener el numero de equipo del cliente
     *
     * @return numeroEquipo
     */
    public int getNumeroEquipo() {
        return numeroEquipo;
    }

    /**
     * metodo que nos permite modificar el numero de equipo del cliente pasamos
     * el numero a String para poder verificar que este mismo contenga 8 digitos
     *
     * @param numeroEquipo representa el numero del cliente
     */
    public void setNumeroEquipo(int numeroEquipo) {
        String x = Integer.toString(numeroEquipo);
        if (x.length() == 8) {
            this.numeroEquipo = numeroEquipo;
        } else {
            System.out.println("numero no valido");
        }
    }

    /**
     * Metodo que nos permite obtener la cuota de navegacion del plan
     *
     * @return coutaNavegacion
     */
    public int getCuotaNavegacion() {
        return cuotaNavegacion;
    }

    /**
     * metodo que nos permite modificar la cuota de navegacion del plan
     *
     * @param cuotaNavegacion representa la cuota de navegacion del plan
     */
    public void setCuotaNavegacion(int cuotaNavegacion) {
        this.cuotaNavegacion = cuotaNavegacion;
    }

    /**
     * Metodo que nos permite obtener los minutos incluidos del plan
     *
     * @return minutosIncluidos
     */
    public int getMinutosIncluidos() {
        return minutosIncluidos;
    }

    /**
     * metodo que nos permite modificar los minutos del plan
     *
     * @param minutosIncluidos representa los minutos incluidos del plan
     */
    public void setMinutosIncluidos(int minutosIncluidos) {
        this.minutosIncluidos = minutosIncluidos;
    }

    /**
     * Metodo que nos permite obtener el cargo fijo mensual del plan
     *
     * @return cargoFijoPlan
     */
    public int getCargoFijoPlan() {
        return cargoFijoPlan;
    }

    /**
     * metodo que nos permite modificar el cargo fijo mensual del plan
     *
     * @param cargoFijoPlan representa el cargo fijo que lleva el plan
     */
    public void setCargoFijoPlan(int cargoFijoPlan) {
        this.cargoFijoPlan = cargoFijoPlan;
    }

    /**
     * Metodo que nos permite obtener el cliente
     *
     * @return cliente
     */
    public Cliente getClietne() {
        return cliente;
    }

    /**
     * metodo que nos permite modificar el cliente
     *
     * @param cliente representa el cliente que contrata el plan
     */
    public void setClietne(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * metodo que nos permite mostrar los datos del cliente "nombre completo" ,
     * "numero equipo" y "el tipo cliente"
     *
     */
    public void listDatos() {
        System.out.println("Nombre del Cliente: " + cliente.getNombreCompleto());
        System.out.println("Numero cliente: " + numeroEquipo);
        System.out.println("El cliente es: " + cliente.getTipoCliente());

    }

    /**
     * Metodo que nos permite validar el equipo del cliente para que
     * correspondan
     * Si es true el equipo del cliente estara validado
     * Si es false el equipo del cliente no estara validado
     * @param numeroEquipo representa el numero del cliente
     * @param rut representa el rut del cliente
     * @return retorno
     *
     */
    public boolean validarEquipoCliente(int numeroEquipo, String rut) {
        boolean retorno = false;
        if (this.numeroEquipo == numeroEquipo && this.cliente.getRut().equals(rut)) {
            retorno = true;
        }

        return retorno;
    }

    /**
     * metodo que calcula el descuento por tipo de cliente
     *
     *
     * @param minAdicionales representa los minutos adicionales que se le
     * agregan al plan
     * @return descuento
     */
    public double montoMinutosAdicionales(int minAdicionales) {
        int valorMinAdicional = 150;

        double descuento = valorMinAdicional * minAdicionales;
        if (cliente.getTipoCliente().equals("cliente preferencial")) {
            descuento = descuento - (descuento * 0.10);
        }

        return descuento;
    }

    /**
     * metodo que suma el cargo fijo del plan mas el cobro por minuto adicional
     *
     * @return montoPorPagar
     */
    public double montoPagoCliente() {

        double montoPorPagar = cargoFijoPlan + this.montoMinutosAdicionales(1);

        return montoPorPagar;
    }

    /**
     * Metodo que nos permite obtener el aumento de cuota de navegacion del plan
     *
     * @return aumentoNavegacion
     */
    public int aumentoNavegacion() {
        int aumentoNavegacion = this.cuotaNavegacion + 10; //aca le aumentamos la cuota en 10 gb
        return aumentoNavegacion;
    }

    /**
     * Metodo que suma la cantidad de minutos adicionales que se usan al plan
     * nos retorna la suma de de minutos y si se sobre pasa del limite de 300 adicionales
     * nos impreme un string diciendo que has alcanzado la cuota maxima
     *
     * @param minutos representa los minutos adicionales que se le dan al plan
     * @return aumentoCuota
     */ 
    public int minutosAdicionales(int minutos) {
        int aumentoMax = 300;
        int aumentoCuota = 0;
        boolean g = true ;
        if (minutos > aumentoMax) {
            g = false;
            System.out.println("Cuota maxima alcanzada");
}
        if (g) {
                aumentoCuota = minutos + this.minutosIncluidos;
                System.out.println(aumentoCuota);
            }
        return aumentoCuota;
    }
}
