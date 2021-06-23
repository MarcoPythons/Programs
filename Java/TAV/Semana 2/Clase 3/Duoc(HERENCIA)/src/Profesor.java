/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Informática
 */
public class Profesor extends Persona {
    
    private String especialidad;
    private String contrato;

    public Profesor() {
    }

    public Profesor(String especialidad, String contrato, String rut, String nombreCompleto) {
        super(rut, nombreCompleto);
        this.especialidad = especialidad;
        this.contrato = contrato;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
    @Override
    public void mostrarDatos() {
       
        System.out.println("Datos del profesor");
        System.out.println("-------------------------");
        System.out.println("Nombre Completo: "+ this.nombreCompleto);
        System.out.println("Rut: "+ this.rut);
        System.out.println("Especialidad: " + this.especialidad);
        System.out.println("Contrato: " + this.contrato);
        System.out.println("-------------------------");

    }
    
}
