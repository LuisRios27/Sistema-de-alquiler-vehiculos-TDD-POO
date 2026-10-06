import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClienteTest {
    @Test
    @DisplayName("Si un Cliente se crea con numero 5 asignado, tieneNumero devuelve true si se compara con 5.")
    public void test01SiClienteTieneMismoNumeroConElQueFueCreadoTieneNumeroDevuelveTrue() {
        // Arrange
        int numeroDeCliente = 5;
        Cliente unCliente = new Cliente(numeroDeCliente);

        // Act & Assert
        assertTrue(unCliente.tieneNumero(numeroDeCliente));
    }

    @Test
    @DisplayName("Si un Cliente se crea con numero 5 asignado, tieneNumero devuelve false si se compara con 6.")
    public void test02SiClienteNoTieneMismoNumeroConElQueFueCreadoTieneNumeroDevuelveFalse() {
        // Arrange
        int numeroDeCliente = 5;
        int otroNumero = 6;
        Cliente unCliente = new Cliente(numeroDeCliente);

        // Act & Assert
        assertFalse(unCliente.tieneNumero(otroNumero));
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
    @DisplayName("Intentar crear un Cliente con numero de cliente negativo lanza excepcion NumeroDeClienteInvalidoException.")
    public void test04SeIntentaCrearClienteConNumeroDeClienteNegativoSeLanzaNumeroDeClienteInvalidoException() {
        // Arrange
        int numeroDeCliente = -1;

        // Act & Assert
        assertThrows(NumeroDeClienteInvalidoException.class, () -> {
            new Cliente(numeroDeCliente);
        });
    }

    @Test
    @DisplayName("Un cliente alquila un camion por 3 dias el precio total de sus alquileres es 30000.0")
    public void test05ClienteAlquilaCamionPor3DiasYPrecioDeAlquilerTotalDeAlquileresDeClienteEs30000() {
        // Arrange
        int dias = 3;
        Vehiculo unVehiculo = new Camion("LMRH-2827");
        Cliente unCliente = new Cliente(1);

        // Act
        unCliente.alquila(unVehiculo, dias);

        // Assert
        assertEquals(30000.0, unCliente.precioTotalAlquileres());
    }

    @Test
    @DisplayName("Un cliente alquila 2 camiones por 3 dias el precio total de sus alquileres es 60000.0")
    public void test06ClienteAlquila2CamionesPor3DiasYPrecioDeAlquilerTotalDeAlquileresDeClienteEs60000() {
        // Arrange
        int dias = 3;
        Vehiculo unVehiculo = new Camion("LMRH-2827");
        Vehiculo otroVehiculo = new Camion("TLCP-2809");
        Cliente unCliente = new Cliente(1);

        // Act
        unCliente.alquila(unVehiculo, dias);
        unCliente.alquila(otroVehiculo, dias);

        // Assert
        assertEquals(60000.0, unCliente.precioTotalAlquileres());
    }

    @Test
    @DisplayName("Un cliente alquila un Coche premium blindado de 5 plazas por 5 dias, el precio total de sus alquileres es 7187.5")
    public void test07ClienteAlquilaCochePremiumBlindado5PlazasPor5DiasPrecioTotalDeAlquileresEs7187punto5() {
        // Arrange
        Categoria premium = new Premium();
        int dias = 5;
        Vehiculo unVehiculo = new Coche("LMRH-2827", 5, premium, true);
        Cliente unCliente = new Cliente(1);

        // Act
        unCliente.alquila(unVehiculo, dias);

        // Assert
        assertEquals(7187.5, unCliente.precioTotalAlquileres(), 0.01);
    }

    @Test
    @DisplayName("Un cliente no alquila ningun vehiculo, el precio total de sus alquileres es 0.0")
    public void test08ClienteNoAlquilaVehiculosPrecioTotalDeAlquileresDelClienteEs0() {
        // Arrange
        Cliente unCliente = new Cliente(1);

        // Act & Assert
        assertEquals(0.0, unCliente.precioTotalAlquileres());
    }
}
