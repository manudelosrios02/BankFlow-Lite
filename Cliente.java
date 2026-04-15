import java.util.HashMap;
import java.util.Map;

public class Cliente {

    private int generadorId = 0;

    private String nombre;
    private String dni;
    private int idCliente;
    private Map<String, Cuenta> cuentas; // Cada cuenta se identifica por un IBAN

    public Cliente(String nombre, String dni, int idCliente) {
        this.nombre = nombre;
        this.dni = dni;
        this.idCliente = ++generadorId;
        this.cuentas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Map<String, Cuenta> getCuentas(){
        return new HashMap<>(cuentas);
    }


    public void agregarCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser null");
        }

        String iban = cuenta.getIban();

        if (iban == null || iban.isBlank()) {
            throw new IllegalArgumentException("IBAN no valido");
        }

        if (cuentas.containsKey(iban)) {
            throw new IllegalArgumentException("Imposible crear una nueva cuenta con ese IBAN");
        }

        cuentas.put(iban, cuenta);
    }

    public Cuenta obtenerCuenta(String iban) {
        if(iban == null || iban.isBlank()) {
            throw new IllegalArgumentException("Introduzca un IBAN");
        }

        Cuenta cuenta = cuentas.get(iban);

        if(cuenta == null) {
            throw new IllegalArgumentException("Introduzca un IBAN válido");
        }

        return cuenta;
    }

    public void mostrarDatos() {
        System.out.println("ID cliente: " + idCliente);
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Número de cuentas " + cuentas.size());
    }

}
