import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private final int numero;
    private final List<Alquiler> alquileres;

    public Cliente(int numero) {
        if (numero <= 0) {
            throw new NumeroDeClienteInvalidoException("Numero de cliente invalido: " + numero);
        }
        this.numero = numero;
        this.alquileres = new ArrayList<>();
    }

    public void alquila(Vehiculo unVehiculo, int dias) {
        Alquiler nuevoAlquiler = new Alquiler(unVehiculo, dias);
        alquileres.add(nuevoAlquiler);
    }

    public double precioTotalAlquileres() {
        double valorTotalAlquileres = 0.0;
        for (Alquiler alquiler : alquileres) {
            valorTotalAlquileres += alquiler.precio();
        }
        return valorTotalAlquileres;
    }

    public boolean tieneNumero(int numeroAComparar) {
        return numeroAComparar == this.numero;
    }
}
