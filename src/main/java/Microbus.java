public class Microbus extends Vehiculo {

    private static final double MONTO_BASE_DIARIO = 1500.0;
    private static final double MONTO_EXTRA_FIJO = 500.0;

    public Microbus(String patente) {
        super(patente);
    }

    @Override
    public double precio(int dias) {
        return MONTO_BASE_DIARIO * dias + MONTO_EXTRA_FIJO;
    }
}