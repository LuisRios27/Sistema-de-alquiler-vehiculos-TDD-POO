import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FurgonetaTest {
    @Test
    @DisplayName("El precio de alquiler de una furgoneta con PMA = 2, por 3 dias, es de 2100.0.")
    public void test01ElPrecioDeAlquilerPor3DiasConPMA2Es2100() {
        // Arrange
        Vehiculo unaFurgoneta = new Furgoneta("LMRH-2827", 2);

        // Act & Assert
        assertEquals(2100.0, unaFurgoneta.precio(3));
    }

    @Test
    @DisplayName("El precio de alquiler de una furgoneta con PMA = 1, por 3 dias, es de 1800.0.")
    public void test02ElPrecioDeAlquilerPor3DiasConPMA1Es1800() {
        // Arrange
        Vehiculo unaFurgoneta = new Furgoneta("LMRH-2827", 1);

        // Act & Assert
        assertEquals(1800.0, unaFurgoneta.precio(3));
    }

    @Test
    @DisplayName("Se lanza excepcion al crear una furgoneta con PMA igual a cero.")
    public void test03FurgonetaPMAIgualACeroSeLanzaPMAInvalidoException() {
        // Act & Assert
        assertThrows(PMAInvalidoException.class, () -> {
            new Furgoneta("LMRH-2827", 0);
        });
    }

    @Test
    @DisplayName("Se lanza excepcion al crear una furgoneta con PMA negativo.")
    public void test04FurgonetaPMAMenorACeroSeLanzaPMAInvalidoException() {
        // Act & Assert
        assertThrows(PMAInvalidoException.class, () -> {
            new Furgoneta("LMRH-2827", -2);
        });
    }
}