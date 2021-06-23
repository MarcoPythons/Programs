
import java.util.Objects;



/**
 *
 * @author Informática
 */
public abstract class  Persona {
    
    protected String rut;
    protected String nombreCompleto;

    public Persona() {
    }

    public Persona(String rut, String nombreCompleto) {
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.rut, other.rut)) {
            return false;
        }
        if (!Objects.equals(this.nombreCompleto, other.nombreCompleto)) {
            return false;
        }
        return true;
    }
    
    public void mostrarDatos(){
        System.out.println("-----------------------");
        System.out.println("        PEROSNA");
        System.out.println("Rut: "+ rut);
        System.out.println("Nombre completo: "+ nombreCompleto);
        System.out.println("------------------------");
    }
    
}
