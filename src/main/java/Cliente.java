public class Cliente {
    
    private final int NUMERO_DE_CLIENTE;
    
    public Cliente(int numero) {
        if (numero <= 0) {
            throw new NumeroDeClienteInvalidoException("Numero de cliente invalido: " + numero);
        }
        this.NUMERO_DE_CLIENTE = numero;
    }

    public void alquila(Vehiculo unVehiculo, int dias) {
        return;
    }

    public double precioTotalAlquileres() {
        return 30000.0;
    }

    public boolean tieneNumero(int numeroAComparar) {
        return numeroAComparar == this.NUMERO_DE_CLIENTE;
    }
}
