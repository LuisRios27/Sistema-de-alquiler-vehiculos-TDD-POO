import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    private int cantidadClientes;

    public Agencia() {
        this.cantidadClientes = 0;
    }

    public double precioTotal() {
        return 0.0;
    }

    public int agregarCliente() {
        
        cantidadClientes++;

        return this.cantidadClientes;
    }

    /**
     * Registra un nuevo vehiculo y comprueba que la patente no este duplicada.
     * @exception VehiculoYaRegistradoAnteriormenteException es lanzada si ya hay un vehiculo con la misma patente
     * @param unVehiculo
     */
    public void registrarVehiculo(Vehiculo unVehiculo) {
        if (this.estaRegistrado(unVehiculo) == true)
            throw new VehiculoYaRegistradoAnteriormenteException("El vehiculo ya fue registrado anteriormente.");
        this.vehiculos.add(unVehiculo);
    }

    public boolean estaRegistrado(Vehiculo unVehiculo) {
        boolean estaRegistrado = false;
        if (vehiculos.size() > 0) {
            Vehiculo vehiculoParaComparar = null;
            int i = 0;
            while (i < vehiculos.size() && estaRegistrado == false) {
                vehiculoParaComparar = vehiculos.get(i);
                estaRegistrado = vehiculoParaComparar.tieneMismaPatente(unVehiculo);
                i++;
            }
        }
        return estaRegistrado;
    }
}