public class Alquiler {
    private Vehiculo vehiculo;
    private final int dias;
    public Alquiler(Vehiculo unVehiculo, int dias) {
        if (dias <= 0) {
            throw new CantidadDiasInvalidaException("Valor Invalido: " + dias);
        }
        this.vehiculo = unVehiculo;
        this.dias = dias;
    }

    public double precio() {
        return vehiculo.precio(this.dias);
    }
}
