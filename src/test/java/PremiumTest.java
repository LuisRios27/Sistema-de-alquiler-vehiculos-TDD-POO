import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PremiumTest {
    @Test
    @DisplayName("El precio de 5 plazas es 750")
    public void test01PrecioDe5plazasEs750() {
        // Arrange
        Categoria premium = new Premium();

        // Act & Assert
        assertEquals(750.0, premium.precioPlazas(5));
    }
}
