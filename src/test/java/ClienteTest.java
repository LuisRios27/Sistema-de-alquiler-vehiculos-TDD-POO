import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClienteTest extends RuntimeException {
    @Test
    @DisplayName("Si un Cliente se crea con numero 5 asignado, tieneMismo numero devuelve true si se compara con 5.")
    public void test01SiClienteTieneMismoNumeroConElQueFueCreadoTieneMismoNumeroDevuelveTrue() {
        // Arrange
        int numeroDeCliente = 5;
        Cliente unCliente = new Cliente(numeroDeCliente);

        // Act & Assert
        assertEquals(true, unCliente.tieneNumero(numeroDeCliente));
    }

    @Test
    @DisplayName("Si un Cliente se crea con numero 5 asignado, tieneMismo numero devuelve false si se compara con 6.")
    public void test02SiClienteNoTieneMismoNumeroConElQueFueCreadoTieneMismoNumeroDevuelveFalse() {
        // Arrange
        int numeroDeCliente = 5;
        int otroNumero = 6;
        Cliente unCliente = new Cliente(numeroDeCliente);

        // Act & Assert
        assertEquals(false, unCliente.tieneNumero(otroNumero));
    }

    @Test
    @DisplayName("Intentar crear un Cliente con numero de cliente = 0 lanza excepcion NumeroDeClienteInvalidoException.")
    public void test03SeIntentaCrearClienteConNumeroDeClienteIgualACeroSeLanzaNumeroDeClienteInvalidoException() {
        // Arrange
        int numeroDeCliente = 0;
        assertThrows(NumeroDeClienteInvalidoException.class, () -> {
            new Cliente(numeroDeCliente);
        });
    }
}