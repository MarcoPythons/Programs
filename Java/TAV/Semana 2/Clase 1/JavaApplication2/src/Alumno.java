
/**
 *
 * @author Maily
 */
public class Alumno {
    
    private String rut;
    private String nombreCompleto;
    private int edad;

    public Alumno() {
    }

    public Alumno(String rut, String nombreCompleto, int edad) {
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void mostrarDatos(){
        System.out.println("--------------------------");
        System.out.println("          Alumno");
        System.out.println("--------------------------");
        System.out.println("Nombre Completo: " +nombreCompleto);
        System.out.println("Rut: " + rut);
        System.out.println("Edad: "+ edad);
    }
    
    
}
