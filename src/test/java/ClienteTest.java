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
}
