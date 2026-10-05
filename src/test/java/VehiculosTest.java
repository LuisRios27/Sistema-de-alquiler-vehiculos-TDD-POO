import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VehiculosTest {
    @Test
    @DisplayName("Se crea un Vehiculo con una patente asociada.")
    public void test01SeCreaUnVehiculoConUnaPatenteQueDespuesSeVerificaSiEsLaMisma() {
        // Arrange
        String patenteAAsignar = "LMRH-2827";
        Vehiculo unCamion = new Camion(patenteAAsignar);
        Vehiculo otroCamion = new Camion(patenteAAsignar);
        
        // Act & Assert
        boolean esMismaPatente = unCamion.tieneMismaPatente(otroCamion);
        assertEquals(true, esMismaPatente);
    }

    @Test
    @DisplayName("Si un vehiculo NO tiene misma patente que el vehiculo recibido por parametro, se retorna false.")
    public void test02SiUnVehiculoNoTieneMismaPatenteQueOtroDevuelveFalse(){
        // Arrange
        Vehiculo unVehiculo = new Camion("LMRH-2827");
        Vehiculo otroVehiculo = new Camion("TLCP-2809");

        // Act & Assert
        assertEquals(false, unVehiculo.tieneMismaPatente(otroVehiculo));
    }
}