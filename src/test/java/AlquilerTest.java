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

    @Test
    @DisplayName("El Alquiler por 1 dia de un Coche premium de 4 plazas blindado tiene un precio de 1265.0")
    public void test03PrecioDeAlquilerPor1DiaDeUnCochePremium4plazasBlindadoEs1265() {
        // Arrange
        Categoria categoriaPremium = new Premium();
        Vehiculo unVehiculo = new Coche("TLCP-2809", 4, categoriaPremium, true);
        int dias = 1;
        Alquiler unAlquiler = new Alquiler(unVehiculo, dias);

        // Act & Assert
        assertEquals(1265.0, unAlquiler.precio());
    }

    @Test
    @DisplayName("Crear un alquiler de un Microbus por 0 dias, lanza excepcion CantidadDiasInvalidaException.")
    public void test04AlquilerPor0DiasDeUnVehiculoLanzaCantidadDiasInvalidaException() {
        // Arrange
        Vehiculo unVehiculo = new Microbus("LMRH-2827");
        int dias = 0;

        // Act & Assert
        assertThrows(CantidadDiasInvalidaException.class, () -> {
            new Alquiler(unVehiculo, dias);
        });
    }

    @Test
    @DisplayName("Crear un alquiler de un Microbus por dias menores a cero, se lanza excepcion CantidadDiasInvalidaException.")
    public void test05AlquilerPorDiasMenoresACeroDeUnVehiculoLanzaCantidadDiasInvalidaException() {
        // Arrange
        Vehiculo unVehiculo = new Microbus("LMRH-2827");
        int dias = -2;

        // Act & Assert
        assertThrows(CantidadDiasInvalidaException.class, () -> {
            new Alquiler(unVehiculo, dias);
        });
    }
}