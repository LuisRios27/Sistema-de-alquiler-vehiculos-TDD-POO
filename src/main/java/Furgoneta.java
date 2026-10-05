public class Furgoneta extends Vehiculo {
    private static final double PRECIO_BASE_DIARIO = 500;
    private static final double PRECIO_POR_PMA = 300;
    private final int pma;

    public Furgoneta(String patente, int pma) {
        super(patente);
        this.pma = pma;
    }

    @Override
    public double precio(int dias) {
        return (PRECIO_BASE_DIARIO * dias) + (PRECIO_POR_PMA * pma);
    }
}
