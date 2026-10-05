public class Furgoneta extends Vehiculo {
    private static final double PRECIO_POR_PMA = 300;
    private final int pma;

    public Furgoneta(String patente, int pma) {
        super(patente);
        if (pma <= 0) {
            throw new PMAInvalidoException("PMA no puede ser menor o igual a cero. Valor recibido: " + pma);
        }
        this.pma = pma;
    }

    @Override
    public double precio(int dias) {
        return (COSTO_BASE * dias) + (PRECIO_POR_PMA * pma);
    }
}
