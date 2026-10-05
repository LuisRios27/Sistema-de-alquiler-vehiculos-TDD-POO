import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CocheTest {
    @Test 
    @DisplayName("El precio de alquiler por 5 dias de un coche clasico sin blindaje de 4 plazas es 4500.")
    public void test01PrecioDeCocheClasicoSinBlindaje4Plazas5DiasEs4500() {
        // Arrange
        Categoria clasico = new Clasico();
        Vehiculo unCoche = new Coche("LMRH-2827", 4, clasico, false);

        // Act & Assert
        assertEquals(4500.0, unCoche.precio(5));
    }

    @Test
    @DisplayName("El precio de alquiler por 6 dias de un coche clasico blindado con 5 plazas es 6900 aprox.")
    public void test02PrecioDeCocheClasicoBlindado5Plazas6DiasEs6900() {
        // Arrange
        Categoria clasico = new Clasico();
        Vehiculo unCoche = new Coche("LMRH-2827", 5, clasico, true);
        
        // Act & Assert
        assertEquals(6900.0, unCoche.precio(6), 0.01);
    }

    @Test
    @DisplayName("El precio de alquiler un coche premium de 5 plazas blindado por 5 dias es 7187.5")
    public void test03PrecioDeCochePremiumBlindado5Plazas5DiasEs7187() {
        // Arrange
        Categoria premium = new Premium();
        Vehiculo unCoche = new Coche("LMRH-2701", 5, premium, true);

        // Act & Assert
        assertEquals(7187.5, unCoche.precio(5), 0.001);
    }

    @Test
    @DisplayName("El precio de alquiler de un coche premium de 5 plazas no blindado por 5 dias es 6250.")
    public void test04PrecioDeCochePremiumSinBlindaje5Plazas5DiasEs6250() {
        // Arrange
        Categoria premium = new Premium();
        Vehiculo unCoche = new Coche("TLCP-2809", 5, premium, false);
        
        // Act & Assert
        assertEquals(6250, unCoche.precio(5), 0.001);
    }
}