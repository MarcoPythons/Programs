/*
 * 
 * 
 */

/**
 *
 * @author Marco Peña
 */
public class Rut {

    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase(); // Este linea es para pasar todos los Strings a mayusculas
            rut = rut.replace(".", ""); // Esta linea remplaza los "." por un espacio en blanco ""
            rut = rut.replace("-", ""); // Esta linea remplaza los "-" por un espacio en blanco ""
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1)); // esta linea toma de la posicion 0 hasta la 8 y le resta la posicion 8 (digito verificador)

            char dv = rut.charAt(rut.length() - 1); // Esta variable toma el digito verificador

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

}
