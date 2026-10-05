public class Alquiler {
    private final Vehiculo vehiculo;
    private final int dias;

    public Alquiler(Vehiculo unVehiculo, int dias) {
        if (dias <= 0) {
            throw new CantidadDiasInvalidaException("Cantidad de dias invalida: " + dias);
        }
        this.vehiculo = unVehiculo;
        this.dias = dias;
    }

    public double precio() {
        return vehiculo.precio(this.dias);
    }
}
