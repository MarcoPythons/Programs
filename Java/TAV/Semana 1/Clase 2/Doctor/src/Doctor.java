
import java.util.Objects;

/*  Esto es una clase de Doctor que tiene los datos de un doctor,
 * su especialidad y su turno.
 * Esta clase sirve de practica para estructurar una clase
 */
/**
 *
 * @author Marco Peña
 * @version 1.0
 */
public class Doctor {

    String rut; //Atributo que representa el rut del doctor
    String nombre; // Atributo representa el nombre del doctor
    String apellido; // Atributo representa el apellido del doctor
    int edad; // Atributo que representa la edad del doctor
    String especialidad; //Atributo que representa la especialidad del doctor
    boolean turno; //Atributo que representa el turno del doctor

    /**
     * Constructor sin parametros para la clase Doctor
     */
    public Doctor() {
    }

    /**
     * Constructor con parametros de la Doctor
     *
     * @param rut de tipo String que representa el rut del doctor
     * @param nombre de tipo String que representa el nombre del doctor
     * @param apellido de tipo String que representa el apellido del doctor
     * @param edad de tipo int que representa la edad del doctor
     * @param especialidad de tipo String que representa la especialidad del
     * doctor
     * @param turno de tipo de boolean que "false" significa diurno y "true"
     * significa vespertino
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Doctor(String rut, String nombre, String apellido, int edad, String especialidad, boolean turno) {
        this.setRut(rut);
        this.nombre = nombre;
        this.apellido = apellido;
        this.setEdad(edad);
        this.especialidad = especialidad;
        this.turno = turno;
    }

    /**
     * metodo que retorna el rut del doctor
     *
     * @return rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * metodo que permite modificar el rut del doctor
     *
     * @param rut
     */
    public void setRut(String rut) {
        if (rut.length() >= 8) {
            this.rut = rut;
        } else {
            System.out.println("El rut debe ser sin puntos y sin el digito verificador ");
        }

    }

    /**
     * metodo que retorna el nombre del doctor
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo que permite modificar el nombre del doctor
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este metodo retorna el apellido del doctor
     *
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Este metodo permite modificar el apellido del doctor
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Este metodo retorna la edad del doctor
     *
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Este metodo permite modificar la edad del doctor. La edad no puede ser
     * menor a 25 años
     *
     * @param edad
     */
    public void setEdad(int edad) {
        if (edad < 25) {
            this.edad = edad;
        } else {
            System.out.println("La edad minima es 25 años");

        }

    }

    /**
     * Este metodo retorna la especialidad del doctor
     *
     * @return especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Este metodo permite modificar la especialidad del doctor
     *
     * @param especialidad
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Este metodo retorna el turno del doctor false : diurno true : vespertino
     *
     * @return turno
     */
    public boolean getTurno() {
        return turno;
    }

    /**
     * Este metodo permite modificar el turno del doctor
     *
     * @param turno
     */
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    /**
     * Este metodo muestra los datos de un doctor solo en el caso que la
     * especialidad del doctor sea radiologia
     */
    public void mostrarDatosDoctor() {

        if (this.especialidad.equals("radiologo") && this.edad >= 25) {
            System.out.println("El rut del doctor es: " + this.rut);
            System.out.println("El nombre del doctor es: " + this.nombre);
            System.out.println("El apellido del doctor es: " + this.apellido);
            System.out.println("La edad del doctor es: " + this.edad);
            System.out.println("La especialidad del doctor es: " + this.especialidad);
            if (this.turno == true) {
                System.out.println("El turno del doctor es: Vespertino");
            } else {
                System.out.println("El turno del doctor es: Diurno");
            }
        } else {
            System.out.println("Solo se puede mostrar los datos de un radiologo y no puede ser menor de 25 años");
        }

    }
    /**
     * Este método transforma a String los atributos del doctor
     * @return Doctor
     */
    @Override
    public String toString() {
        return "Doctor :" + "El rut del doctor es: " + rut + ",el nombre del doctor es: " + nombre + ",el apellido del doctor es: " + apellido;
    }
    /**
     *  Este método compara el rut, el nombre y el apellido del doctor para ver si los datos pertenecen al mismo doctor
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
        final Doctor other = (Doctor) obj;
        if (!Objects.equals(this.rut, other.rut)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return true;
    }

}
