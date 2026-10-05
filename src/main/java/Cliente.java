public class Cliente {
    
    private final int NUMERO_DE_CLIENTE;
    
    public Cliente(int numero) {
        this.NUMERO_DE_CLIENTE = numero;
    }

    public boolean tieneNumero(int numeroAComparar) {
        return numeroAComparar == this.NUMERO_DE_CLIENTE;
    }
}
