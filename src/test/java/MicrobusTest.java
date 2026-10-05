import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MicrobusTest {
    @Test
    @DisplayName("El precio para alquilar un Microbus por 5 dias es de 8000.0")
    public void test01ElPrecioDeAlquilerPor5DiasEs8000() {
        // Arrange
        Vehiculo unVehiculo = new Microbus("LMRH-2827");

        // Act & Assert
        assertEquals(8000.0, unVehiculo.precio(5));
    }

    @Test
    @DisplayName("El precio para alquilar un Microbus por 1 dia es de 2000.0")
    public void test02ElPrecioDeAlquilerPor1DiaEs2000() {
        // Arrange
        Vehiculo unVehiculo = new Microbus("LMRH-2827");

        // Act & Assert
        assertEquals(2000.0, unVehiculo.precio(1));
    }
}