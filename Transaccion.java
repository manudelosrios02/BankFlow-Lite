import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaccion {

    private int generadorId = 0;

    private int idTransaccion;
    private String tipo;
    private BigDecimal cantidad;
    private LocalDate fecha;

    public Transaccion(String tipo, BigDecimal cantidad, LocalDate fecha) {
        this.idTransaccion = ++generadorId;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String mostrarResumen() {
        return "Transacción[ " +
                "id: " + idTransaccion +
                ", tipo: " + tipo +
                ", cantidad: " + cantidad + 
                ", fecha: " + fecha + 
                "]";
    }

    @Override
    public String toString() {
        return mostrarResumen();
    }

}
