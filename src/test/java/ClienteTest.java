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

        // Act & Assert
        assertThrows(NumeroDeClienteInvalidoException.class, () -> {
            new Cliente(numeroDeCliente);
        });
    }

    @Test
    @DisplayName("Un cliente alquila un camion por 3 dias el precio total de sus alquileres es 30000.0")
    public void test04ClienteAlquilaCamionPor3DiasYPrecioDeAlquilerTotalDeAlquileresDeCLienteEs30000() {
        // Arrange
        int dias = 3;
        Vehiculo unVehiculo = new Camion("LMRH-2827");
        Cliente unCliente = new Cliente(1);

        // Act & Assert
        unCliente.alquila(unVehiculo, dias);
        assertEquals(30000.0, unCliente.precioTotalAlquileres());
    }

    @Test
    @DisplayName("Un cliente alquila 2 camiones por 3 dias el precio total de sus alquileres es 60000.0")
    public void test05ClienteAlquila2CamionesPor3DiasYPrecioDeAlquilerTotalDeAlquileresDeCLienteEs60000() {
        // Arrange
        int dias = 3;
        Vehiculo unVehiculo = new Camion("LMRH-2827");
        Vehiculo otroVehiculo = new Camion("TLCP-2809");
        Cliente unCliente = new Cliente(1);

        // Act & Assert
        unCliente.alquila(unVehiculo, dias);
        unCliente.alquila(otroVehiculo, dias);
        assertEquals(60000.0, unCliente.precioTotalAlquileres());
    }

    @Test
    @DisplayName("Un cliente no alquila ningun vehiculo, el precio total de sus alquileres es 0.0")
    public void test06ClienteNoAlquilaVehiculosPrecioTotalDeAlquileresDelCLienteEs0() {
        // Arrange
        Cliente unCliente = new Cliente(1);

        // Act & Assert
        assertEquals(0.0, unCliente.precioTotalAlquileres());
    }
}