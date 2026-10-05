import java.util.ArrayList;
import java.util.List;

public class Cliente {
    
    private final int NUMERO_DE_CLIENTE;
    private List<Alquiler> alquileres;
    
    public Cliente(int numero) {
        if (numero <= 0) {
            throw new NumeroDeClienteInvalidoException("Numero de cliente invalido: " + numero);
        }
        this.NUMERO_DE_CLIENTE = numero;
        this.alquileres = new ArrayList<>();
    }

    public void alquila(Vehiculo unVehiculo, int dias) {
        Alquiler nuevoAlquiler = new Alquiler(unVehiculo, dias);
        alquileres.add(nuevoAlquiler);
    }

    public double precioTotalAlquileres() {
        int valorTotalAlquileres = 0;
        for (Alquiler alquiler : alquileres) {
            valorTotalAlquileres += alquiler.precio();
        }
        return valorTotalAlquileres;
    }

    public boolean tieneNumero(int numeroAComparar) {
        return numeroAComparar == this.NUMERO_DE_CLIENTE;
    }
}
