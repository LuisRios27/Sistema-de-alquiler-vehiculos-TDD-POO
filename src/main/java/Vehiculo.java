public abstract class Vehiculo {
    
    private final String patente;
    protected static final double COSTO_BASE = 500.0; 
    
    public Vehiculo(String patente) {
        this.patente = patente;
    }

    public abstract double precio(int dias);

    /**
     * Comprueba si la patente del vehiculo recibido es igual a la suya.
     * 
     * @param vehiculoAComparar
     * @return un valor booleano que indica si la patente de este objeto es igual a la pasada por parametro
     */
    public boolean tieneMismaPatente(Vehiculo vehiculoAComparar) {
        return this.patente.equals(vehiculoAComparar.patente);
    }
}