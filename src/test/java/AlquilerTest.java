import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlquilerTest {
    @Test
    @DisplayName("El Alquiler por 3 dias de un Camion tiene un precio de 30000.0")
    public void test01ElPrecioDeAlquilerDeUnCamionEs30000() {
        // Arrange
        Vehiculo unVehiculo = new Camion("TLCP-2809");
        int dias = 3;
        Alquiler unAlquiler = new Alquiler(unVehiculo, dias);

        // Act & Assert
        assertEquals(30000.0, unAlquiler.precio());
    }

    @Test
    @DisplayName("El Alquiler por 3 dias de un Microbus tiene un precio de 5000.0")
    public void test02ElPrecioDeAlquilerPor3DiasDeUnMicrobusEs5000() {
        // Arrange
        Vehiculo unVehiculo = new Microbus("TLCP-2809");
        int dias = 3;
        Alquiler unAlquiler = new Alquiler(unVehiculo, dias);

        // Act & Assert
        assertEquals(5000.0, unAlquiler.precio());
    }
}