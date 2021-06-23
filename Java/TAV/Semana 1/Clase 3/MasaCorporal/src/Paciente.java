/*
 * Esta es para calcular el imc de algun Paciente
 * Esta misma tiene el nombre, apellido, edad ,genero, peso y estatura
 * Esta clase tambien nos permite visualisar sus datos personales y el estado nutricional
 */

/**
 *
 * @author Marco Peña
 */
public class Paciente {

    private String nombre; // Atributo que representa el nombre del Paciente
    private String apellido; // atributo que representa el apellido del Paciente
    private int edad; // atributo que representa la edad del Paciente
    private boolean genero; // atributo que represemta el genero del Paciente, si es "true" es es masculino y si es "false" es femenino
    private double peso; // atributo que representa el peso del Paciente
    private double estatura; // atributo que representa la estatura del Paciente

    /**
     * Constructor default sin parametros
     */
    public Paciente() {
    }

    /**
     * Constructor con parametros de la clase paciente
     *
     * @param nombre de tipo String que representa el nombre del Paciente
     * @param apellido de tipo String que representa el apellido del Paciente
     * @param edad de tipo int que representa la edad del Paciente
     * @param genero de tipo boolean que representa el genero del Paciente. true
     * para Masculino y false para Femenino
     * @param peso de tipo double que representa el peso del Paciente
     * @param estatura de tipo double que representa la estatura del Paciente
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Paciente(String nombre, String apellido, int edad, boolean genero, double peso, double estatura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.setEdad(edad);
        this.genero = genero;
        this.setPeso(peso);
        this.setEstatura(estatura);
    }

    /**
     * Método que perimte obtener el nombre del Paciente
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este método permite modifica el nombre del Paciente
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este mètodo permite obtener el apellido del Paciente
     *
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Este método permite modificar el apellido del Paciente
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Este método permite obtener la edad del Paciente
     *
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Este método permite modificar la edad del Paciente La edad debe estar en
     * el rango de 2 a 99 años
     *
     * @param edad
     */
    public void setEdad(int edad) {
        if (edad > 1 && 100 > edad) {
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser negativa");
        }
    }

    /**
     * Este método permite obtener el genero del Paciente
     *
     * @return genero
     */
    public boolean isGenero() {
        return genero;
    }

    /**
     * Este método permite modificar el genero del Paciente
     *
     * @param genero
     */
    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    /**
     * Este método permite obtener el peso del Paciente
     *
     * @return peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Este método permite modificar el peso del Paciente El peso no puede ser
     * negativo ni 0
     *
     * @param peso
     */
    public void setPeso(double peso) {
        if (peso > 0.0) {
            this.peso = peso;
        } else {
            System.out.println("El peso no puede ser negativo");
        }
    }

    /**
     * Este método permite obtener la estatura del Paciente
     *
     * @return estatura
     */
    public double getEstatura() {
        return estatura;
    }

    /**
     * Este método permite modificar la estatura del Paciente La estatura no
     * puede ser negativa, 0 ó mayor a 2.72(record de altura más alta)
     *
     * @param estatura
     */
    public void setEstatura(double estatura) {
        if (estatura > 0.0) {
            this.estatura = estatura;
        } else {
            System.out.println("La estatura no puede ser negativa");
        }
       if (estatura < 2.72)
            this.estatura = estatura;
       else
            System.out.println("La temperatura no puede ser mayor a 2.72");
    }

    /**
     * Este método calcula el imc del Paciente Primero se crea una variable de
     * tipo double "estaturaAlCuadrado" y multiplicamos la estatura * estatura
     * luego se crea otra variable de tipo double "imc" para dividir el peso por
     * la "estaturaAlCuadrado". Este método retorna el imc ya calculado.
     *
     * @return imc
     */
    public double calculoImc() {

        double estaturaAlCuadrado = estatura * estatura;
        double imc = peso / estaturaAlCuadrado;
        return imc;

    }

    /**
     * Este método nos permite visualisar el estado nutricional del Paciente Los
     * estados nutricionales son: bajo peso, peso normal, sobre peso, obasidad
     * grado I, obesidad grado II, obesidad grado III
     *
     * @return Un String que indica el estado nutricional segun su imc
     */
    public String estadoNutricional() {

        double imc = this.calculoImc();

        if (imc < 18.5) {
            return "bajo peso";
        }
        if (imc <= 24.9 && imc >= 18.5) {
            return "peso normal";
        }
        if (imc <= 29.9 && imc >= 25.0) {
            return "sobre peso";
        }
        if (imc <= 34.5 && imc >= 30.0) {
            return "obesidad grado I";
        }
        if (imc <= 39.9 && imc >= 35.0) {
            return "obesidad grado II";
        }
        if (imc > 40.0) {
            return "obesidad grado III;";
        } else {
            return "Calculo no realizado";
        }
    }

    /**
     * Este método nos muestra los datos del Paciente, incluyendo el estado
     * nutricional y el valor del IMC
     */
    public void mostrarDatos() {

        String imc = this.estadoNutricional();
        double imc1 = this.calculoImc();

        System.out.println("Nombre :" + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        if (genero) {
            System.out.println("Genero: Masculino");
        } else {
            System.out.println("Genero: Femenino");
        }
        System.out.println("Peso: " + peso);
        System.out.println("Estatura: " + estatura);
        System.out.println("IMC : " + imc1);
        System.out.println("Informacion nutricional: " + imc);

    }
}
