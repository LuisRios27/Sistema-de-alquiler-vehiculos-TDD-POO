import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();

    private int cantidadClientes;

    public Agencia() {
        this.cantidadClientes = 0;
    }

    public double precioTotal() {
        double precioTotalDeAlquileres = 0.0;
        for (Cliente cliente : clientes) {
            precioTotalDeAlquileres += cliente.precioTotalAlquileres();
        }
        return precioTotalDeAlquileres;
    }

    /**
     * Devuelve la suma de los precios de todos los alquileres de un cliente.
     * @exception ClienteNoRegistradoException es lanzada si el numero de cliente no esta registrado
     */
    public double precioTotalDelCliente(int numeroCliente) {
        return this.buscarCliente(numeroCliente).precioTotalAlquileres();
    }

    public int agregarCliente() {
        cantidadClientes++;
        clientes.add(new Cliente(cantidadClientes));

        return this.cantidadClientes;
    }

    /**
     * Asigna un alquiler de un vehiculo, por una cantidad de dias, a un cliente.
     * @exception ClienteNoRegistradoException es lanzada si el numero de cliente no esta registrado
     * @exception VehiculoNoRegistradoException es lanzada si el vehiculo no esta registrado
     */
    public void alquilar(int numeroCliente, Vehiculo unVehiculo, int dias) {
        Cliente cliente = this.buscarCliente(numeroCliente);
        if (!this.estaRegistrado(unVehiculo)) {
            throw new VehiculoNoRegistradoException("El vehiculo no esta registrado.");
        }
        cliente.alquila(unVehiculo, dias);
    }

    private Cliente buscarCliente(int numeroCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.tieneNumero(numeroCliente)) {
                return cliente;
            }
        }
        throw new ClienteNoRegistradoException("El cliente " + numeroCliente + " no esta registrado.");
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