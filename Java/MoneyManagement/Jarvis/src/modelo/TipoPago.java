package modelo;

/**
 *
 * @author marco
 */
public class TipoPago {

    private int code;
    private String fecha;
    private String metodoPago;
    private float gasto;
    private String notas;

    public TipoPago() {
    }

    public TipoPago(String fecha, String metodoPago, float gasto, String notas) {
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.gasto = gasto;
        this.notas = notas;
    }

    public TipoPago(int code, String fecha, String metodoPago, float gasto, String notas) {
        this.code = code;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.gasto = gasto;
        this.notas = notas;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public float getGasto() {
        return gasto;
    }

    public void setGasto(float gasto) {
        this.gasto = gasto;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "TipoPago{" + "code=" + code + ", fecha=" + fecha + ", metodoPago=" + metodoPago + ", gasto=" + gasto + ", notas=" + notas + '}';
    }
  
}
