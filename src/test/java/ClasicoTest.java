import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClasicoTest {
    @Test
    @DisplayName("El precio de 5 plazas son 500.")
    public void test01PrecioDe5PlazasEs500() {
        // Arrange
        Categoria clasico = new Clasico();

        // Act & Assert
        assertEquals(500.0, clasico.precioPlazas(5));
    }
}
