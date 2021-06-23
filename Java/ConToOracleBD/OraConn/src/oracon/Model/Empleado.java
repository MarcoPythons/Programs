package oracon.Model;

public class Empleado {

    private String idempleado;
    private String nombres;
    private String apellido;
    private String rut;
    private char estadoCivil;

    public Empleado(String idempleado, String nombres, String apellido, String rut, char estadoCivil) {
        this.idempleado = idempleado;
        this.nombres = nombres;
        this.apellido = apellido;
        this.rut = rut;
        this.estadoCivil = estadoCivil;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public char getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(char estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idempleado=" + idempleado + ", nombres=" + nombres + ", apellido=" + apellido + ", rut=" + rut + ", estadoCivil=" + estadoCivil + '}';
    }
    
    
};
