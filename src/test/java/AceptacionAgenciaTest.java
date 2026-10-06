import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test de aceptacion: escenario completo de punta a punta con los cuatro tipos de vehiculo.
 * Cliente 1: coche clasico de 4 plazas por 5 dias (4500) + microbus por 3 dias (5000).
 * Cliente 2: furgoneta con PMA 2 por 3 dias (2100) + camion por 1 dia (30000).
 */
public class AceptacionAgenciaTest {

    private Agencia unaAgencia;
    private int primerCliente;
    private int segundoCliente;

    @BeforeEach
    public void setUp() {
        unaAgencia = new Agencia();
        Vehiculo unCoche = new Coche("AAA-111", 4, new Clasico(), false);
        Vehiculo unMicrobus = new Microbus("BBB-222");
        Vehiculo unaFurgoneta = new Furgoneta("CCC-333", 2);
        Vehiculo unCamion = new Camion("DDD-444");
        unaAgencia.registrarVehiculo(unCoche);
        unaAgencia.registrarVehiculo(unMicrobus);
        unaAgencia.registrarVehiculo(unaFurgoneta);
        unaAgencia.registrarVehiculo(unCamion);
        primerCliente = unaAgencia.agregarCliente();
        segundoCliente = unaAgencia.agregarCliente();
        unaAgencia.alquilar(primerCliente, unCoche, 5);
        unaAgencia.alquilar(primerCliente, unMicrobus, 3);
        unaAgencia.alquilar(segundoCliente, unaFurgoneta, 3);
        unaAgencia.alquilar(segundoCliente, unCamion, 1);
    }

    @Test
    @DisplayName("El precio total de los alquileres del primer cliente es 9500.0")
    public void test01PrecioTotalDelPrimerClienteEs9500() {
        // Act & Assert
        assertEquals(9500.0, unaAgencia.precioTotalDelCliente(primerCliente));
    }

    @Test
    @DisplayName("El precio total de los alquileres del segundo cliente es 32100.0")
    public void test02PrecioTotalDelSegundoClienteEs32100() {
        // Act & Assert
        assertEquals(32100.0, unaAgencia.precioTotalDelCliente(segundoCliente));
    }

    @Test
    @DisplayName("El precio total de todos los alquileres de la agencia es 41600.0")
    public void test03PrecioTotalDeLaAgenciaEs41600() {
        // Act & Assert
        assertEquals(41600.0, unaAgencia.precioTotal());
    }
}
