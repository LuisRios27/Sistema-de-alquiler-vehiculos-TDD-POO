public class Camion extends Vehiculo {

    private static final double COSTO_FIJO = 30000.0;
    
    public Camion(String patente) {
        super(patente);
    }

    @Override
    public double precio(int dias) {
        return COSTO_FIJO; 
    }
}
