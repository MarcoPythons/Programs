
/**
 *
 * @author Nicolas Garces
 * @author Marco Peña
 */
public class Test {

    public static void main(String[] args) {
        Cliente c = new Cliente("20.203.805-0", "Marco peña", "marc.penar@alumnos.duoc.cl", "P");
        Plan p = new Plan(65753352, 100, 200, 10000, c);
        //c.mostrarDatos();

        //p.listDatos();
        //c.mostrarDatos();
        //System.out.println(p.validarEquipoCliente(p.getNumeroEquipo(), c.getRut()));

        //p.minutosAdicionales(200);
        //System.out.println(p.montoMinutosAdicionales(1));
        //System.out.println(p.montoPagoCliente());
        //System.out.println(p.aumentoNavegacion());
    }

}
