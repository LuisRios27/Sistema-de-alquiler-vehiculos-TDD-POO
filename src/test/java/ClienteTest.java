import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClienteTest extends RuntimeException {
    @Test
    @DisplayName("Cliente se crea con su numero de cliente recibido como argumento del constructor")
    public void test01ClienteSeCreaConSuNumeroDeClienteRespectivo() {
        // Arrange
        int numeroDeCliente = 1;
        Cliente unCliente = new Cliente(numeroDeCliente);

        // Act & Assert
        assertEquals(true, unCliente.tieneNumero(numeroDeCliente));
    }
}
