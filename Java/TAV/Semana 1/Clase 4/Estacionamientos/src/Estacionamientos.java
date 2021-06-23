
import java.util.Calendar; // se importa el paquete java.util.Calendar para poder modificar fechas
import java.util.Date; // se importa el paquete java.util.Date para poder manejar fechas
import java.util.Objects; // se importa el paquete java.util.objects para poder aplicar el metodo equals

/*
 * Esta clase representa un estacionamiento
 * Este mismo cobra por el estacionamiento a $20 el min
 * 
 */
/**
 *
 * @author Marco Peña
 */
public class Estacionamientos {

    private Vehiculo vehiculo; //Atributo que representa el Vehiculo que entra al estacionamiento
    private Date fechaIngreso; //Atributo que representa la fecha de ingreso del vehiculo
    private Date horaIngreso; //Atributo que representa la hora de ingreso del vehiculo
    private Date horaSalida; //Atributo que representa la hora de salida del vehiculo

    /**
     * Constructor sin argumentos para la clase Estacionamiento
     */
    public Estacionamientos() {
    }

    /**
     * Constructor con argumentos para la clase Estacionamiento
     *
     * @param vehiculo de tipo Vehiculo que representa el vehiculo que entra al
     * estacionamiento
     * @param fechaIngreso de tipo Date que representa la fecha de ingreso al
     * estacionamiento
     * @param horaIngreso de tipo Date que representa la hora de ingreso al
     * estacionamiento
     * @param horaSalida de tipo Date que representa la hora de salida al
     * estacionamiento
     */
    public Estacionamientos(Vehiculo vehiculo, Date fechaIngreso, Date horaIngreso, Date horaSalida) {
        this.vehiculo = vehiculo;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
    }

    /**
     * Metodo que nos permite obtener los datos del vehiculo que entra al
     * estacionamiento
     *
     * @return Vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * metodo que nos permite modificar el vehiculo que entra al estacionamiento
     *
     * @param vehiculo
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Metodo que nos permite obtener la fecha de ingreso del vehiculo
     *
     * @return fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Este metodo nos permite modificar la fecha de ingreso
     *
     * @param fechaIngreso
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Este metodo nos permite obtener la hora de ingreso del vehiculo
     *
     * @return horaIngreso
     */
    public Date getHoraIngreso() {
        return horaIngreso;
    }

    /**
     * Este metodo nos premite modificar la hora de ingreso del vehiculo al
     * estacionamiento
     *
     * @param horaIngreso
     */
    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    /**
     * Este metodo nos permite obtener la hora de salida del vehiculo
     *
     * @return horaSalida
     */
    public Date getHoraSalida() {
        return horaSalida;
    }

    /**
     * este metodo nos permite modificar la hora de salida del vehiculo
     *
     * @param horaSalida
     */
    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    /**
     * Este metodo nos permite verificar si el Vehiculo es el mismo Vehiculo que
     * entro al estacionamiento y si este cumple, nos retorna un true
     *
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
        final Estacionamientos other = (Estacionamientos) obj;
        if (!Objects.equals(this.vehiculo, other.vehiculo)) {
            return false;
        }
        if (!Objects.equals(this.fechaIngreso, other.fechaIngreso)) {
            return false;
        }
        if (!Objects.equals(this.horaIngreso, other.horaIngreso)) {
            return false;
        }
        if (!Objects.equals(this.horaSalida, other.horaSalida)) {
            return false;
        }
        return true;
    }

    /**
     * Este metodo nos permite calcular cuantos minutos estuvo el vehiculo en el
     * estacionamiento, esto lo hace restandole la hora de salida con la hora de
     * entrada y este nos retorna los milisegundos de este tiempo, entonces lo
     * tendremos que dividir por 100 y luego por 60 y luego otra vez por 60 para
     * que nos de la cantidad de horas
     *
     * @return diferencia // esta representa los minutos de que paso el vehiculo
     * en el estacionamiento
     */
    public long tiempoEnEstacionamiento() {

        horaIngreso = new Date();
        horaSalida = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(horaIngreso);

        long i = calendar.getTimeInMillis();
        calendar.setTime(horaSalida);
        calendar.add(Calendar.HOUR,2);
        long f = calendar.getTimeInMillis();
        long diferencia = (f - i) / 1000 / 60 / 60 ;
        return diferencia;
    }

    /**
     * Este metodo toma lo que retorna el metodo tiempoEnEstacionamiento y este
     * lo multiplica por 20 y el resultado de esto es el valor a pagar por el
     * estacionamiento, si este monto supera los 10.000 el monto sera capado a
     * 10.000
     *
     * @return valorFinal // este representa la cantidad a pagar
     */
    public long calculoDetiempoEstacionamiento() {
        long mintosEnEstacionamiento = this.tiempoEnEstacionamiento();
        int valorMinuto = 20;
        int horaEnMinto = 60;
        int valorFinal = valorMinuto * ((int) mintosEnEstacionamiento * horaEnMinto);

        if (valorFinal >= 10000) {
            valorFinal = 10000;
        }

        return valorFinal;
    }

    /**
     * Este metodo nos imprime un voucher para el dueño del vehiculo en este
     * metodo tambien se suma los minutos a la hora de entrada para que muestre
     * la hora de salida del vehiculo
     */
    public void voucher() {
        Calendar horaSalida = Calendar.getInstance();
        horaSalida.setTime(fechaIngreso);
        int horaEnMinto = 60;
        int minSalida = horaSalida.get(Calendar.MINUTE);
        int hrsSalida = horaSalida.get(Calendar.HOUR_OF_DAY);
        int secSalida = horaSalida.get(Calendar.SECOND);

        long minutos = this.tiempoEnEstacionamiento();
        Calendar hora = Calendar.getInstance();
        int hrs = hora.get(Calendar.HOUR_OF_DAY);
        int min = hora.get(Calendar.MINUTE);
        int sec = hora.get(Calendar.SECOND);

        if (minSalida <= horaEnMinto) {
            int h = hrsSalida + (int) this.tiempoEnEstacionamiento();
            if (h < 24) {
                h = 00;
                h = hrsSalida + (int) this.tiempoEnEstacionamiento();

                System.out.println("------------------------------");
                System.out.println("			VOUCHER");
                System.out.println("	     (Fecha - Hora)");
                System.out.println("------------------------------");
                System.out.println("Patente vehiculo: " + this.vehiculo.getPatente());
                System.out.println("Fecha Ingreso   : " + this.fechaIngreso);
                System.out.println("Hora Ingreso    : " + hrs + ":" + min + ":" + sec);
                System.out.println("Hora Salida     : " + h + ":" + minSalida + ":" + secSalida);
                System.out.println("Total Minutos   : " + minutos * horaEnMinto);
                System.out.println("Total Pagar     : " + this.calculoDetiempoEstacionamiento());
                System.out.println("------------------------------");
            }
        }

    }
}
