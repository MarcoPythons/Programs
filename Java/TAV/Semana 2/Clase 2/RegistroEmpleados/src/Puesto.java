
/**
 *
 * @author Marco Peña
 */
public class Puesto {

    private int codigo;
    private String nombrePuesto;

    public Puesto() {
    }

    public Puesto(int codigo, String nombrePuesto) {
        this.setCodigo(codigo);
        this.nombrePuesto = nombrePuesto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {

        if (codigo > 0 && codigo <= 100) {

            this.codigo = codigo;

        } else {
            System.out.println("El codigo no puede ser menor a 1 ni mayor a 100 ni puede ser duplicado");

        }
    }


public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

}
