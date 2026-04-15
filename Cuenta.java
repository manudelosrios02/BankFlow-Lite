import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;


public class Cuenta {

    private Cliente titular;
    private String iban;
    private String moneda;
    private BigDecimal saldo;
    private List<Transaccion> transacciones;

    public Cuenta(Cliente titular, String iban, String moneda) {
        this.titular = titular;
        this.iban = iban;
        this.moneda = moneda;
        this.saldo = BigDecimal.ZERO;
        this.transacciones = new ArrayList<>();
    }

    public Cliente getTitular() {
        return titular;
    }

    public String getIban() {
        return iban;
    }

    public String getMoneda() {
        return moneda;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public List<Transaccion> getTransacciones() {
        return new ArrayList<>(transacciones);
    }

    // Método que permite ingresar dinero en una cuenta, generando una transaccion que se guarda en una lista
    public void ingresar(BigDecimal cantidad) {
        
        if (cantidad == null || cantidad.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("La cantidad a ingresar debe ser mayor que 0");
        }

        saldo = saldo.add(cantidad);

        transacciones.add(new Transaccion(
            "INGRESO",
            cantidad,
            LocalDate.now()
        ));
    }

    // Método que permite retirar dinero de una cuenta, idem
    public void retirar(BigDecimal cantidad) {

        if (cantidad == null || cantidad.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0.");
        }

        if (saldo.compareTo(cantidad) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        saldo = saldo.subtract(cantidad);

        transacciones.add(new Transaccion (
            "RETIRADA",
            cantidad,
            LocalDate.now()
        ));
    }

    // Método que convuerte un BigDecimal en un String con formato de dinero según la moneda. Permite consultar el saldo de una cuenta
    public String consultarSaldo() {
        NumberFormat formato = NumberFormat.getCurrencyInstance(); // Crea un formateador que sigue el formato del sistema
        Currency currency = Currency.getInstance(moneda); // Crea un objeto que representa la moneda (EUR, USD, etc)

        formato.setCurrency(currency); // Configura la moneda que debe usar el formateador

        return formato.format(saldo.setScale(2, RoundingMode.HALF_EVEN)); // Redondea el saldo a 2 decimales para visualizar
    }

    // Método que compueba que dos cuentas tienen la misma moneda
    public boolean mismaMoneda(Cuenta otraCuenta) {
        return this.moneda.equals(otraCuenta.moneda);
    }

    // Método que muestra los datos de una cuenta
    public void mostrarDatos() {
        System.out.println("IBAN: " + iban);
        System.out.println("Titular: " + titular.getNombre());
        System.out.println("Saldo: " + consultarSaldo());
        System.out.println("Contador transacciones: " + transacciones.size());
    }

    @Override
    public String toString() {
        return "Cuenta[ " +
                "IBAN: " + iban +
                ", saldo: " + saldo +
                ", moneda: " + moneda +
                "]";
    }



}


