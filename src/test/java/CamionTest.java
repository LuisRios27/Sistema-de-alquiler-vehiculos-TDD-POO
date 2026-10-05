import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CamionTest {
    @Test
    @DisplayName("El precio de alquiler de un camion siempre es 30000 sin importar la cantidad de dias.")
    public void test01CamionDevuelveMontoDePrecioTotal() {
        // Arrange
        Vehiculo unCamion = new Camion("LMRH-2827");

        // Act & Assert
        assertEquals(30000.0, unCamion.precio(20));
        assertEquals(30000.0, unCamion.precio(5));
    }
}
